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
<FormItem label="交易编号" prop="fundsWithdrawTransactionNo">
	<Input v-model="searchForm.fundsWithdrawTransactionNo" placeholder="请输入交易编号"/>
</FormItem>
<FormItem label="提现金额"><Row>
	<i-col span="11">
	<FormItem prop="fundsWithdrawAmountMin">
	<InputNumber v-model="searchForm.fundsWithdrawAmountMin" placeholder="请输入开始提现金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="fundsWithdrawAmountMax">
	<InputNumber v-model="searchForm.fundsWithdrawAmountMax" placeholder="请输入结束提现金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提现银行卡"><Row>
	<i-col span="11">
	<FormItem prop="fundsWithdrawBankcardIdMin">
	<InputNumber v-model="searchForm.fundsWithdrawBankcardIdMin" placeholder="请输入开始提现银行卡" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="fundsWithdrawBankcardIdMax">
	<InputNumber v-model="searchForm.fundsWithdrawBankcardIdMax" placeholder="请输入结束提现银行卡" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="完成时间"><Row>
	<i-col span="11">
	<FormItem prop="fundsWithdrawCompleteTimeMin">
	<DatePicker @on-change="searchForm.fundsWithdrawCompleteTimeMin=$event" :value="searchForm.fundsWithdrawCompleteTimeMin" placeholder="请输入开始完成时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="fundsWithdrawCompleteTimeMax">
	<DatePicker @on-change="searchForm.fundsWithdrawCompleteTimeMax=$event" :value="searchForm.fundsWithdrawCompleteTimeMax" placeholder="请输入结束完成时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提现状态"><Row>
	<i-col span="11">
	<FormItem prop="fundsWithdrawCheckWithdrawStatusMin">
	<InputNumber v-model="searchForm.fundsWithdrawCheckWithdrawStatusMin" placeholder="请输入开始提现状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="fundsWithdrawCheckWithdrawStatusMax">
	<InputNumber v-model="searchForm.fundsWithdrawCheckWithdrawStatusMax" placeholder="请输入结束提现状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提现描述" prop="fundsWithdrawCheckWithdrawDescription">
	<Input v-model="searchForm.fundsWithdrawCheckWithdrawDescription" placeholder="请输入提现描述"/>
</FormItem>
<FormItem label="审核人编号"><Row>
	<i-col span="11">
	<FormItem prop="fundsWithdrawCheckCheckedUserIdMin">
	<InputNumber v-model="searchForm.fundsWithdrawCheckCheckedUserIdMin" placeholder="请输入开始审核人编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="fundsWithdrawCheckCheckedUserIdMax">
	<InputNumber v-model="searchForm.fundsWithdrawCheckCheckedUserIdMax" placeholder="请输入结束审核人编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="fundsWithdrawCheckCreateTimeMin">
	<DatePicker @on-change="searchForm.fundsWithdrawCheckCreateTimeMin=$event" :value="searchForm.fundsWithdrawCheckCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="fundsWithdrawCheckCreateTimeMax">
	<DatePicker @on-change="searchForm.fundsWithdrawCheckCreateTimeMax=$event" :value="searchForm.fundsWithdrawCheckCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
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
<p>交易编号: <span v-text="form.fundsWithdrawTransactionNo"></span></p>
<p>提现金额: <span v-text="form.fundsWithdrawAmount"></span></p>
<p>提现银行卡: <span v-text="form.fundsWithdrawBankcardId"></span></p>
<p>完成时间: <span v-text="form.fundsWithdrawCompleteTime"></span></p>
<p>提现状态: <span v-text="form.fundsWithdrawCheckWithdrawStatus"></span></p>
<p>提现描述: <span v-text="form.fundsWithdrawCheckWithdrawDescription"></span></p>
<p>审核人编号: <span v-text="form.fundsWithdrawCheckCheckedUserId"></span></p>
<p>创建时间: <span v-text="form.fundsWithdrawCheckCreateTime"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'UserWithdrawCheck',
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
          searchUrl: '/user-withdraw-check/admin/pager-cond',
          allUrl: '/user-withdraw-check/admin/all',
          detailUrl: '/user-withdraw-check/admin/one/',
          multiUrl: '/user-withdraw-check/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          userId: null,
userPhone: null,
userEmail: null,
fundsWithdrawTransactionNo: null,
fundsWithdrawAmount: null,
fundsWithdrawBankcardId: null,
fundsWithdrawCompleteTime: null,
fundsWithdrawCheckWithdrawStatus: null,
fundsWithdrawCheckWithdrawDescription: null,
fundsWithdrawCheckCheckedUserId: null,
fundsWithdrawCheckCreateTime: null,

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
fundsWithdrawTransactionNo: null,
fundsWithdrawAmount: null,
fundsWithdrawAmountMin: null, 
fundsWithdrawAmountMax: null, 
fundsWithdrawBankcardId: null,
fundsWithdrawBankcardIdMin: null, 
fundsWithdrawBankcardIdMax: null, 
fundsWithdrawCompleteTime: null,
fundsWithdrawCompleteTimeMin: null, 
fundsWithdrawCompleteTimeMax: null, 
fundsWithdrawCheckWithdrawStatus: null,
fundsWithdrawCheckWithdrawStatusMin: null, 
fundsWithdrawCheckWithdrawStatusMax: null, 
fundsWithdrawCheckWithdrawDescription: null,
fundsWithdrawCheckCheckedUserId: null,
fundsWithdrawCheckCheckedUserIdMin: null, 
fundsWithdrawCheckCheckedUserIdMax: null, 
fundsWithdrawCheckCreateTime: null,
fundsWithdrawCheckCreateTimeMin: null, 
fundsWithdrawCheckCreateTimeMax: null, 

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
title: '交易编号',
key: 'fundsWithdrawTransactionNo',
minWidth: 120,
sortable: true
},
{
title: '提现金额',
key: 'fundsWithdrawAmount',
minWidth: 120,
sortable: true
},
{
title: '提现银行卡',
key: 'fundsWithdrawBankcardId',
minWidth: 120,
sortable: true
},
{
title: '完成时间',
key: 'fundsWithdrawCompleteTime',
minWidth: 120,
sortable: true
},
{
title: '提现状态',
key: 'fundsWithdrawCheckWithdrawStatus',
minWidth: 120,
sortable: true
},
{
title: '提现描述',
key: 'fundsWithdrawCheckWithdrawDescription',
minWidth: 120,
sortable: true
},
{
title: '审核人编号',
key: 'fundsWithdrawCheckCheckedUserId',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'fundsWithdrawCheckCreateTime',
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
