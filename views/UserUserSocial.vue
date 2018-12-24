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
	<InputNumber v-model="searchForm.userIdMin" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userIdMax">
	<InputNumber v-model="searchForm.userIdMax" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="手机号" prop="userPhone">
	<Input v-model="searchForm.userPhone"/>
</FormItem>
<FormItem label="用户邮箱" prop="userEmail">
	<Input v-model="searchForm.userEmail"/>
</FormItem>
<FormItem label="第三方登录OAuth openid" prop="userSocialOpenid">
	<Input v-model="searchForm.userSocialOpenid"/>
</FormItem>
<FormItem label="第三方登录OAuth unionid" prop="userSocialUnionId">
	<Input v-model="searchForm.userSocialUnionId"/>
</FormItem>
<FormItem label="刷新Token" prop="userSocialRefreshToken">
	<Input v-model="searchForm.userSocialRefreshToken"/>
</FormItem>
<FormItem label="第三方登录类型" prop="userSocialSocialType">
	<Input v-model="searchForm.userSocialSocialType"/>
</FormItem>
<FormItem label="第三方登录绑定时间"><Row>
	<i-col span="11">
	<FormItem prop="userSocialCreateTimeMin">
	<DatePicker @on-change="searchForm.userSocialCreateTimeMin=$event" :value="searchForm.userSocialCreateTimeMin" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userSocialCreateTimeMax">
	<DatePicker @on-change="searchForm.userSocialCreateTimeMax=$event" :value="searchForm.userSocialCreateTimeMax" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
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
<p>第三方登录OAuth openid: <span v-text="form.userSocialOpenid"></span></p>
<p>第三方登录OAuth unionid: <span v-text="form.userSocialUnionId"></span></p>
<p>刷新Token: <span v-text="form.userSocialRefreshToken"></span></p>
<p>第三方登录类型: <span v-text="form.userSocialSocialType"></span></p>
<p>第三方登录绑定时间: <span v-text="form.userSocialCreateTime"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'UserUserSocial',
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
          searchUrl: '/user-usersocial/pager-cond',
          allUrl: '/user-usersocial/all',
          detailUrl: '/user-usersocial/one/',
          multiUrl: '/user-usersocial/multi/'
        },
        page: {
          total: 0
        },
        form: {
          userId: null,
userPhone: null,
userEmail: null,
userSocialOpenid: null,
userSocialUnionId: null,
userSocialRefreshToken: null,
userSocialSocialType: null,
userSocialCreateTime: null,

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
userSocialOpenid: null,
userSocialUnionId: null,
userSocialRefreshToken: null,
userSocialSocialType: null,
userSocialCreateTime: null,
userSocialCreateTimeMin: null, 
userSocialCreateTimeMax: null, 

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
width: 120,
sortable: true
},
{
title: '手机号',
key: 'userPhone',
width: 120,
sortable: true
},
{
title: '用户邮箱',
key: 'userEmail',
width: 120,
sortable: true
},
{
title: '第三方登录OAuth openid',
key: 'userSocialOpenid',
width: 120,
sortable: true
},
{
title: '第三方登录OAuth unionid',
key: 'userSocialUnionId',
width: 120,
sortable: true
},
{
title: '刷新Token',
key: 'userSocialRefreshToken',
width: 120,
sortable: true
},
{
title: '第三方登录类型',
key: 'userSocialSocialType',
width: 120,
sortable: true
},
{
title: '第三方登录绑定时间',
key: 'userSocialCreateTime',
width: 120,
sortable: true
},

            {
              title: '操作',
              key: 'action',
              width: 180,
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
      this.fitTable()
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
      },
      fitTable() {
        utils.fitTable(this, 'dataTable', this.table.tableColumns, ['userId','userPhone','userEmail','userSocialOpenid','userSocialUnionId','userSocialRefreshToken','userSocialSocialType','userSocialCreateTime',])
      }
    }
  }
</script>

<style>
</style>
