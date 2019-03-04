<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="confirmSelection" type="primary">确认选择</Button>&nbsp;
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
        <FormItem label="日志编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始日志编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束日志编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
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
<FormItem label="用户账号" prop="userAccount">
	<Input v-model="searchForm.userAccount" placeholder="请输入用户账号"/>
</FormItem>
<FormItem label="执行说明" prop="description">
	<Input v-model="searchForm.description" placeholder="请输入执行说明"/>
</FormItem>
<FormItem label="User-Agent" prop="userAgent">
	<Input v-model="searchForm.userAgent" placeholder="请输入User-Agent"/>
</FormItem>
<FormItem label="请求URL" prop="requestUrl">
	<Input v-model="searchForm.requestUrl" placeholder="请输入请求URL"/>
</FormItem>
<FormItem label="请求方式" prop="requestMethod">
	<Input v-model="searchForm.requestMethod" placeholder="请输入请求方式"/>
</FormItem>
<FormItem label="请求参数" prop="requestParams">
	<Input v-model="searchForm.requestParams" placeholder="请输入请求参数"/>
</FormItem>
<FormItem label="响应编码"><Row>
	<i-col span="11">
	<FormItem prop="responseCodeMin">
	<InputNumber v-model="searchForm.responseCodeMin" placeholder="请输入开始响应编码" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="responseCodeMax">
	<InputNumber v-model="searchForm.responseCodeMax" placeholder="请输入结束响应编码" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="响应消息" prop="responseMsg">
	<Input v-model="searchForm.responseMsg" placeholder="请输入响应消息"/>
</FormItem>
<FormItem label="完整类名" prop="executeClass">
	<Input v-model="searchForm.executeClass" placeholder="请输入完整类名"/>
</FormItem>
<FormItem label="方法名称" prop="executeMethod">
	<Input v-model="searchForm.executeMethod" placeholder="请输入方法名称"/>
</FormItem>
<FormItem label="开始执行时间"><Row>
	<i-col span="11">
	<FormItem prop="executeTimeMin">
	<DatePicker @on-change="searchForm.executeTimeMin=$event" :value="searchForm.executeTimeMin" placeholder="请输入开始开始执行时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="executeTimeMax">
	<DatePicker @on-change="searchForm.executeTimeMax=$event" :value="searchForm.executeTimeMax" placeholder="请输入结束开始执行时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="执行耗时(ms)"><Row>
	<i-col span="11">
	<FormItem prop="executeCostTimeMin">
	<InputNumber v-model="searchForm.executeCostTimeMin" placeholder="请输入开始执行耗时(ms)" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="executeCostTimeMax">
	<InputNumber v-model="searchForm.executeCostTimeMax" placeholder="请输入结束执行耗时(ms)" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否异常"><Row>
	<i-col span="11">
	<FormItem prop="hasExceptionMin">
	<InputNumber v-model="searchForm.hasExceptionMin" placeholder="请输入开始是否异常" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="hasExceptionMax">
	<InputNumber v-model="searchForm.hasExceptionMax" placeholder="请输入结束是否异常" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="异常消息" prop="exceptionMsg">
	<Input v-model="searchForm.exceptionMsg" placeholder="请输入异常消息"/>
</FormItem>
<FormItem label="IP地址" prop="executeIp">
	<Input v-model="searchForm.executeIp" placeholder="请输入IP地址"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="versionMin">
	<InputNumber v-model="searchForm.versionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="versionMax">
	<InputNumber v-model="searchForm.versionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="createTimeMin">
	<DatePicker @on-change="searchForm.createTimeMin=$event" :value="searchForm.createTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="createTimeMax">
	<DatePicker @on-change="searchForm.createTimeMax=$event" :value="searchForm.createTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="updateTimeMin">
	<DatePicker @on-change="searchForm.updateTimeMin=$event" :value="searchForm.updateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="updateTimeMax">
	<DatePicker @on-change="searchForm.updateTimeMax=$event" :value="searchForm.updateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="isActiveMin">
	<InputNumber v-model="searchForm.isActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isActiveMax">
	<InputNumber v-model="searchForm.isActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')">确定</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>日志编号: <span v-text="form.id"></span></p>
<p>用户编号: <span v-text="form.userId"></span></p>
<p>用户账号: <span v-text="form.userAccount"></span></p>
<p>执行说明: <span v-text="form.description"></span></p>
<p>User-Agent: <span v-text="form.userAgent"></span></p>
<p>请求URL: <span v-text="form.requestUrl"></span></p>
<p>请求方式: <span v-text="form.requestMethod"></span></p>
<p>请求参数: <span v-text="form.requestParams"></span></p>
<p>响应编码: <span v-text="form.responseCode"></span></p>
<p>响应消息: <span v-text="form.responseMsg"></span></p>
<p>完整类名: <span v-text="form.executeClass"></span></p>
<p>方法名称: <span v-text="form.executeMethod"></span></p>
<p>开始执行时间: <span v-text="form.executeTime"></span></p>
<p>执行耗时(ms): <span v-text="form.executeCostTime"></span></p>
<p>是否异常: <span v-text="form.hasException"></span></p>
<p>异常消息: <span v-text="form.exceptionMsg"></span></p>
<p>IP地址: <span v-text="form.executeIp"></span></p>
<p>版本号: <span v-text="form.version"></span></p>
<p>创建时间: <span v-text="form.createTime"></span></p>
<p>更新时间: <span v-text="form.updateTime"></span></p>
<p>是否激活: <span v-text="form.isActive"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'SysLogList',
    data() {
      return {
        modal: {
          add: false,
          edit: false,
          search: false,
          detail: false
        },
        urls: {
          searchUrl: '/sys-log/admin/pager-cond',
          allUrl: '/sys-log/admin/all',
          detailUrl: '/sys-log/admin/one/',
          multiUrl: '/sys-log/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
userId: null,
userAccount: null,
description: null,
userAgent: null,
requestUrl: null,
requestMethod: null,
requestParams: null,
responseCode: null,
responseMsg: null,
executeClass: null,
executeMethod: null,
executeTime: null,
executeCostTime: null,
hasException: null,
exceptionMsg: null,
executeIp: null,
version: null,
createTime: null,
updateTime: null,
isActive: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          id: null,
idMin: null, 
idMax: null, 
userId: null,
userIdMin: null, 
userIdMax: null, 
userAccount: null,
description: null,
userAgent: null,
requestUrl: null,
requestMethod: null,
requestParams: null,
responseCode: null,
responseCodeMin: null, 
responseCodeMax: null, 
responseMsg: null,
executeClass: null,
executeMethod: null,
executeTime: null,
executeTimeMin: null, 
executeTimeMax: null, 
executeCostTime: null,
executeCostTimeMin: null, 
executeCostTimeMax: null, 
hasException: null,
hasExceptionMin: null, 
hasExceptionMax: null, 
exceptionMsg: null,
executeIp: null,
version: null,
versionMin: null, 
versionMax: null, 
createTime: null,
createTimeMin: null, 
createTimeMax: null, 
updateTime: null,
updateTimeMin: null, 
updateTimeMax: null, 
isActive: null,
isActiveMin: null, 
isActiveMax: null, 

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
title: '日志编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '用户编号',
key: 'userId',
minWidth: 120,
sortable: true
},
{
title: '用户账号',
key: 'userAccount',
minWidth: 120,
sortable: true
},
{
title: '执行说明',
key: 'description',
minWidth: 120,
sortable: true
},
{
title: 'User-Agent',
key: 'userAgent',
minWidth: 120,
sortable: true
},
{
title: '请求URL',
key: 'requestUrl',
minWidth: 120,
sortable: true
},
{
title: '请求方式',
key: 'requestMethod',
minWidth: 120,
sortable: true
},
{
title: '请求参数',
key: 'requestParams',
minWidth: 120,
sortable: true
},
{
title: '响应编码',
key: 'responseCode',
minWidth: 120,
sortable: true
},
{
title: '响应消息',
key: 'responseMsg',
minWidth: 120,
sortable: true
},
{
title: '完整类名',
key: 'executeClass',
minWidth: 120,
sortable: true
},
{
title: '方法名称',
key: 'executeMethod',
minWidth: 120,
sortable: true
},
{
title: '开始执行时间',
key: 'executeTime',
minWidth: 120,
sortable: true
},
{
title: '执行耗时(ms)',
key: 'executeCostTime',
minWidth: 120,
sortable: true
},
{
title: '是否异常',
key: 'hasException',
minWidth: 120,
sortable: true
},
{
title: '异常消息',
key: 'exceptionMsg',
minWidth: 120,
sortable: true
},
{
title: 'IP地址',
key: 'executeIp',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'version',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'createTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'updateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'isActive',
minWidth: 120,
sortable: true
},

            {
              title: '操作',
              key: 'action',
              width: 80,
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
      },
      confirmSelection() {
        // 确认选择的逻辑
      }
    }
  }
</script>

<style>
</style>
