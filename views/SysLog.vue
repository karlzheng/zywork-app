<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="showModal('add')" type="primary">添加</Button>&nbsp;
          <Dropdown @on-click="batchOpt">
            <Button type="primary">
              批量操作
              <Icon type="ios-arrow-down"></Icon>
            </Button>
            <DropdownMenu slot="list">
              <DropdownItem name="batchActive">批量激活</DropdownItem>
              <DropdownItem name="batchInactive"><span style="color: red;">批量冻结</span></DropdownItem>
              <DropdownItem name="batchRemove" divided><span style="color: red;">批量删除</span></DropdownItem>
            </DropdownMenu>
          </Dropdown>&nbsp;
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
    <Modal v-model="modal.add" title="添加" @on-visible-change="changeModalVisibleResetForm('addForm', $event)">
      <Form ref="addForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="用户编号" prop="userId">
	<InputNumber v-model="form.userId" placeholder="请输入用户编号" style="width: 100%;"/>
</FormItem>
<FormItem label="用户账号" prop="userAccount">
	<Input v-model="form.userAccount" placeholder="请输入用户账号"/>
</FormItem>
<FormItem label="执行说明" prop="description">
	<Input v-model="form.description" placeholder="请输入执行说明"/>
</FormItem>
<FormItem label="User-Agent" prop="userAgent">
	<Input v-model="form.userAgent" placeholder="请输入User-Agent"/>
</FormItem>
<FormItem label="请求URL" prop="requestUrl">
	<Input v-model="form.requestUrl" placeholder="请输入请求URL"/>
</FormItem>
<FormItem label="请求方式" prop="requestMethod">
	<Input v-model="form.requestMethod" placeholder="请输入请求方式"/>
</FormItem>
<FormItem label="请求参数" prop="requestParams">
	<Input v-model="form.requestParams" placeholder="请输入请求参数"/>
</FormItem>
<FormItem label="响应编码" prop="responseCode">
	<InputNumber v-model="form.responseCode" placeholder="请输入响应编码" style="width: 100%;"/>
</FormItem>
<FormItem label="响应消息" prop="responseMsg">
	<Input v-model="form.responseMsg" placeholder="请输入响应消息"/>
</FormItem>
<FormItem label="完整类名" prop="executeClass">
	<Input v-model="form.executeClass" placeholder="请输入完整类名"/>
</FormItem>
<FormItem label="方法名称" prop="executeMethod">
	<Input v-model="form.executeMethod" placeholder="请输入方法名称"/>
</FormItem>
<FormItem label="开始执行时间" prop="executeTime">
	<DatePicker @on-change="form.executeTime=$event" :value="form.executeTime" placeholder="请输入开始执行时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="执行耗时(ms)" prop="executeCostTime">
	<InputNumber v-model="form.executeCostTime" placeholder="请输入执行耗时(ms)" style="width: 100%;"/>
</FormItem>
<FormItem label="是否异常" prop="hasException">
	<InputNumber v-model="form.hasException" placeholder="请输入是否异常" style="width: 100%;"/>
</FormItem>
<FormItem label="异常消息" prop="exceptionMsg">
	<Input v-model="form.exceptionMsg" placeholder="请输入异常消息"/>
</FormItem>
<FormItem label="IP地址" prop="executeIp">
	<Input v-model="form.executeIp" placeholder="请输入IP地址"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="用户编号" prop="userId">
	<InputNumber v-model="form.userId" placeholder="请输入用户编号" style="width: 100%;"/>
</FormItem>
<FormItem label="用户账号" prop="userAccount">
	<Input v-model="form.userAccount" placeholder="请输入用户账号"/>
</FormItem>
<FormItem label="执行说明" prop="description">
	<Input v-model="form.description" placeholder="请输入执行说明"/>
</FormItem>
<FormItem label="User-Agent" prop="userAgent">
	<Input v-model="form.userAgent" placeholder="请输入User-Agent"/>
</FormItem>
<FormItem label="请求URL" prop="requestUrl">
	<Input v-model="form.requestUrl" placeholder="请输入请求URL"/>
</FormItem>
<FormItem label="请求方式" prop="requestMethod">
	<Input v-model="form.requestMethod" placeholder="请输入请求方式"/>
</FormItem>
<FormItem label="请求参数" prop="requestParams">
	<Input v-model="form.requestParams" placeholder="请输入请求参数"/>
</FormItem>
<FormItem label="响应编码" prop="responseCode">
	<InputNumber v-model="form.responseCode" placeholder="请输入响应编码" style="width: 100%;"/>
</FormItem>
<FormItem label="响应消息" prop="responseMsg">
	<Input v-model="form.responseMsg" placeholder="请输入响应消息"/>
</FormItem>
<FormItem label="完整类名" prop="executeClass">
	<Input v-model="form.executeClass" placeholder="请输入完整类名"/>
</FormItem>
<FormItem label="方法名称" prop="executeMethod">
	<Input v-model="form.executeMethod" placeholder="请输入方法名称"/>
</FormItem>
<FormItem label="开始执行时间" prop="executeTime">
	<DatePicker @on-change="form.executeTime=$event" :value="form.executeTime" placeholder="请输入开始执行时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="执行耗时(ms)" prop="executeCostTime">
	<InputNumber v-model="form.executeCostTime" placeholder="请输入执行耗时(ms)" style="width: 100%;"/>
</FormItem>
<FormItem label="是否异常" prop="hasException">
	<InputNumber v-model="form.hasException" placeholder="请输入是否异常" style="width: 100%;"/>
</FormItem>
<FormItem label="异常消息" prop="exceptionMsg">
	<Input v-model="form.exceptionMsg" placeholder="请输入异常消息"/>
</FormItem>
<FormItem label="IP地址" prop="executeIp">
	<Input v-model="form.executeIp" placeholder="请输入IP地址"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
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
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
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
    name: 'SysLog',
    data() {
      return {
        modal: {
          add: false,
          edit: false,
          search: false,
          detail: false
        },
        loading: {
          add: false,
          edit: false,
          search: false
        },
        urls: {
          addUrl: '/sys-log/admin/save',
          batchAddUrl: '/sys-log/admin/batch-save',
          editUrl: '/sys-log/admin/update',
          batchEditUrl: '/sys-log/admin/batch-update',
          searchUrl: '/sys-log/admin/pager-cond',
          allUrl: '/sys-log/admin/all',
          removeUrl: '/sys-log/admin/remove/',
          batchRemoveUrl: '/sys-log/admin/batch-remove',
          detailUrl: '/sys-log/admin/one/',
          activeUrl: '/sys-log/admin/active',
          batchActiveUrl: '/sys-log/admin/batch-active'
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
        validateRules: {
          userAccount: [
{type: 'string', min: 1, max: 100, message: '必须1-100个字符', trigger: 'blur'}
],
description: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 200, message: '必须1-200个字符', trigger: 'blur'}
],
userAgent: [
{type: 'string', min: 1, max: 255, message: '必须1-255个字符', trigger: 'blur'}
],
requestUrl: [
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
requestMethod: [
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
requestParams: [
{type: 'string', min: 1, max: 2000, message: '必须1-2000个字符', trigger: 'blur'}
],
responseMsg: [
{type: 'string', min: 1, max: 100, message: '必须1-100个字符', trigger: 'blur'}
],
executeClass: [
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
executeMethod: [
{type: 'string', min: 1, max: 100, message: '必须1-100个字符', trigger: 'blur'}
],
exceptionMsg: [
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
executeIp: [
{type: 'string', min: 1, max: 100, message: '必须1-100个字符', trigger: 'blur'}
],

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
              title: '激活状态',
              key: 'isActive',
              minWidth: 100,
              align: 'center',
              render: (h, params) => {
                return h('i-switch', {
                  props: {
                    size: 'large',
                    value: params.row.isActive === 0
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    'on-change': (status) => {
                      this.active(params.row)
                    }
                  }
                }, [
                  h('span', {
                    slot: 'open'
                  }, '激活'),
                  h('span', {
                    slot: 'close'
                  }, '冻结')
                ])
              }
            },
            {
              title: '操作',
              key: 'action',
              width: 120,
              align: 'center',
              fixed: 'right',
              render: (h, params) => {
                return h('Dropdown', {
                  on: {
                    'on-click': (itemName) => {
                      this.userOpt(itemName, params.row)
                    }
                  },
                    props: {
                        transfer: true
                    }
                }, [
                  h('Button', {
                      props: {
                        type: 'primary',
                        size: 'small'
                      }
                    }, [
                      '选择操作 ',
                      h('Icon', {
                        props: {
                          type: 'ios-arrow-down'
                        }
                      })
                  ]),
                  h('DropdownMenu', {
                      slot:"list"
                    },[
                      h('DropdownItem', {
                        props:{
                          name: 'showEdit'
                        }
                      }, '编辑'),
                      h('DropdownItem', {
                        props:{
                          name: 'showDetail'
                        }
                      }, '详情'),
                      h('DropdownItem', {
                        props:{
                          name: 'remove'
                        }
                      }, [
                        h('span', {
                          style: {
                            color: 'red'
                          }
                        }, '删除')
                      ])
                  ])
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
      batchOpt(itemName) {
        if (itemName === 'batchActive') {
          utils.batchActive(this, 0)
        } else if (itemName === 'batchInactive') {
          utils.batchActive(this, 1)
        } else if (itemName === 'batchRemove') {
          utils.batchRemove(this)
        }
      },
      userOpt(itemName, row) {
        if (itemName === 'showEdit') {
          utils.showModal(this, 'edit')
          this.form = JSON.parse(JSON.stringify(row))
        } else if (itemName === 'showDetail') {
          utils.showModal(this, 'detail')
          this.form = JSON.parse(JSON.stringify(row))
        } else if (itemName === 'remove') {
          utils.remove(this, row)
        }
      },
      add() {
        utils.add(this)
      },
      edit() {
        utils.edit(this)
      },
      active(row) {
        utils.active(this, row)
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
