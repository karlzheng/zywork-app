<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="showModal('search')" type="primary">高级搜索</Button>&nbsp;
          <Tooltip content="刷新" placement="right">
            <Button icon="md-refresh" type="success" shape="circle" @click="search"></Button>
          </Tooltip>
          <Table ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails" style="margin-top:20px;" @on-selection-change="changeSelection" @on-sort-change="changeSort"></Table>
          <div style="margin: 20px;overflow: hidden">
            <div style="float: right;">
              <Page :total="page.total" :current="searchForm.pageNo" @on-change="changePageNo" @on-page-size-change="changePageSize" showSizer showTotal></Page>
            </div>
          </div>
        </Card>
      </i-col>
    </Row>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="用户编号"><Row>
	<i-col span="11">
	<FormItem prop="userIdMin">
	<InputNumber v-model="searchForm.userIdMin" placeholder="请输入开始用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userIdMax">
	<InputNumber v-model="searchForm.userIdMax" placeholder="请输入结束用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="手机号" prop="userPhone">
	<Input v-model="searchForm.userPhone" placeholder="请输入手机号"/>
</FormItem>
<FormItem label="用户邮箱" prop="userEmail">
	<Input v-model="searchForm.userEmail" placeholder="请输入用户邮箱"/>
</FormItem>
<FormItem label="消息编号"><Row>
	<i-col span="11">
	<FormItem prop="messageIdMin">
	<InputNumber v-model="searchForm.messageIdMin" placeholder="请输入开始消息编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="messageIdMax">
	<InputNumber v-model="searchForm.messageIdMax" placeholder="请输入结束消息编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="消息标题" prop="messageTitle">
	<Input v-model="searchForm.messageTitle" placeholder="请输入消息标题"/>
</FormItem>
<FormItem label="消息摘要" prop="messageSummary">
	<Input v-model="searchForm.messageSummary" placeholder="请输入消息摘要"/>
</FormItem>
<FormItem label="消息内容" prop="messageContent">
	<Input v-model="searchForm.messageContent" placeholder="请输入消息内容"/>
</FormItem>
<FormItem label="消息类型" prop="messageMessageType">
	<Input v-model="searchForm.messageMessageType" placeholder="请输入消息类型"/>
</FormItem>
<FormItem label="是否已读"><Row>
	<i-col span="11">
	<FormItem prop="userMessageIsReadMin">
	<InputNumber v-model="searchForm.userMessageIsReadMin" placeholder="请输入开始是否已读" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userMessageIsReadMax">
	<InputNumber v-model="searchForm.userMessageIsReadMax" placeholder="请输入结束是否已读" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="userMessageCreateTimeMin">
	<DatePicker @on-change="searchForm.userMessageCreateTimeMin=$event" :value="searchForm.userMessageCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userMessageCreateTimeMax">
	<DatePicker @on-change="searchForm.userMessageCreateTimeMax=$event" :value="searchForm.userMessageCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="userMessageUpdateTimeMin">
	<DatePicker @on-change="searchForm.userMessageUpdateTimeMin=$event" :value="searchForm.userMessageUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userMessageUpdateTimeMax">
	<DatePicker @on-change="searchForm.userMessageUpdateTimeMax=$event" :value="searchForm.userMessageUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>用户编号: <span v-text="form.userId"></span></p>
<p>手机号: <span v-text="form.userPhone"></span></p>
<p>用户邮箱: <span v-text="form.userEmail"></span></p>
<p>消息编号: <span v-text="form.messageId"></span></p>
<p>消息标题: <span v-text="form.messageTitle"></span></p>
<p>消息摘要: <span v-text="form.messageSummary"></span></p>
<p>消息内容: <span v-text="form.messageContent"></span></p>
<p>消息类型: <span v-text="form.messageMessageType"></span></p>
<p>是否已读: <span v-text="form.userMessageIsRead"></span></p>
<p>创建时间: <span v-text="form.userMessageCreateTime"></span></p>
<p>更新时间: <span v-text="form.userMessageUpdateTime"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'UserMessage',
    data() {
      return {
        modal: {
          add: false,
          edit: false,
          search: false,
          detail: false
        },
        loading: {
          search: false
        },
        urls: {
          searchUrl: '/user-message/admin/pager-cond',
          allUrl: '/user-message/admin/all',
          detailUrl: '/user-message/admin/one/',
          multiUrl: '/user-message/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          userId: null,
userPhone: null,
userEmail: null,
messageId: null,
messageTitle: null,
messageSummary: null,
messageContent: null,
messageMessageType: null,
userMessageIsRead: null,
userMessageCreateTime: null,
userMessageUpdateTime: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          userId: null,
userIdMin: null, 
userIdMax: null, 
userPhone: null,
userEmail: null,
messageId: null,
messageIdMin: null, 
messageIdMax: null, 
messageTitle: null,
messageSummary: null,
messageContent: null,
messageMessageType: null,
userMessageIsRead: null,
userMessageIsReadMin: null, 
userMessageIsReadMax: null, 
userMessageCreateTime: null,
userMessageCreateTimeMin: null, 
userMessageCreateTimeMax: null, 
userMessageUpdateTime: null,
userMessageUpdateTimeMin: null, 
userMessageUpdateTimeMax: null, 

        },
        table: {
          loading: false,
          tableColumns: [
            {
              type: 'selection',
              width: 45,
              key: "id",
              align: 'center',
              fixed: 'left'
            },
            {
              width: 60,
              align: 'center',
              fixed: "left",
              render: (h, params) => {
                return h('span', params.index + (this.searchForm.pageNo - 1) * this.searchForm.pageSize + 1)
              }
            },
            {
title: '用户编号',
key: 'userId',
minWidth: 120,
sortable: true
},
{
title: '手机号',
key: 'userPhone',
minWidth: 120,
sortable: true
},
{
title: '用户邮箱',
key: 'userEmail',
minWidth: 120,
sortable: true
},
{
title: '消息编号',
key: 'messageId',
minWidth: 120,
sortable: true
},
{
title: '消息标题',
key: 'messageTitle',
minWidth: 120,
sortable: true
},
{
title: '消息摘要',
key: 'messageSummary',
minWidth: 120,
sortable: true
},
{
title: '消息内容',
key: 'messageContent',
minWidth: 120,
sortable: true
},
{
title: '消息类型',
key: 'messageMessageType',
minWidth: 120,
sortable: true
},
{
title: '是否已读',
key: 'userMessageIsRead',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'userMessageCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'userMessageUpdateTime',
minWidth: 120,
sortable: true
},

            {
              title: '操作',
              key: 'action',
              width: 120,
              align: 'center',
              fixed: 'right',
              render: (h, params) => {
                return h('div', [
                  h('Button', {
                    props: {
                      type: 'primary',
                      size: 'small'
                    },
                    style: {
                      marginRight: '5px'
                    },
                    on: {
                      click: () => {
                        this.showDetail('detail', params.row)
                      }
                    }
                  }, '详情')
                ])
              }
            }
          ],
          tableDetails: [],
          selections: []
        }
      }
    },
    computed: {},
    mounted() {
      this.search()
    },
    methods: {
      showModal(modal) {
        utils.showModal(this, modal)
      },
      showDetail(modal, row) {
        utils.showModal(this, modal)
        this.form = row
      },
      changeModalVisibleResetForm(formRef, visible) {
        if (!visible) {
          utils.resetForm(this, formRef)
        }
      },
      resetForm(formRef) {
        utils.resetForm(this, formRef)
      },
      cancelModal(modal) {
        utils.cancelModal(this, modal)
      },
      resetFormCancelModal(formRef, modal) {
        utils.cancelModal(this, modal)
        utils.resetForm(this, formRef)
      },
      searchOkModal(modal) {
        utils.cancelModal(this, modal)
        this.searchForm.pageNo = 1
        utils.search(this)
      },
      search() {
        utils.search(this)
      },
      changeSelection(selections) {
        utils.changeSelections(this, selections)
      },
      changeSort(sortColumn) {
        utils.changeSort(this, sortColumn)
      },
      changePageNo(pageNo) {
        utils.changePageNo(this, pageNo)
      },
      changePageSize(pageSize) {
        utils.changePageSize(this, pageSize)
      }
    }
  }
</script>

<style>
</style>
