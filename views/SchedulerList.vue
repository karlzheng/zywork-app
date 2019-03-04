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
        <FormItem label="作业编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始作业编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束作业编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="作业名称" prop="name">
	<Input v-model="searchForm.name" placeholder="请输入作业名称"/>
</FormItem>
<FormItem label="完整类名" prop="className">
	<Input v-model="searchForm.className" placeholder="请输入完整类名"/>
</FormItem>
<FormItem label="cron表达式" prop="cronExpression">
	<Input v-model="searchForm.cronExpression" placeholder="请输入cron表达式"/>
</FormItem>
<FormItem label="作业组名称" prop="groupName">
	<Input v-model="searchForm.groupName" placeholder="请输入作业组名称"/>
</FormItem>
<FormItem label="触发器名称" prop="triggerName">
	<Input v-model="searchForm.triggerName" placeholder="请输入触发器名称"/>
</FormItem>
<FormItem label="触发器组" prop="triggerGroup">
	<Input v-model="searchForm.triggerGroup" placeholder="请输入触发器组"/>
</FormItem>
<FormItem label="作业描述" prop="description">
	<Input v-model="searchForm.description" placeholder="请输入作业描述"/>
</FormItem>
<FormItem label="作业状态"><Row>
	<i-col span="11">
	<FormItem prop="jobStatusMin">
	<InputNumber v-model="searchForm.jobStatusMin" placeholder="请输入开始作业状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="jobStatusMax">
	<InputNumber v-model="searchForm.jobStatusMax" placeholder="请输入结束作业状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="状态更新时间"><Row>
	<i-col span="11">
	<FormItem prop="jobStatusTimeMin">
	<DatePicker @on-change="searchForm.jobStatusTimeMin=$event" :value="searchForm.jobStatusTimeMin" placeholder="请输入开始状态更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="jobStatusTimeMax">
	<DatePicker @on-change="searchForm.jobStatusTimeMax=$event" :value="searchForm.jobStatusTimeMax" placeholder="请输入结束状态更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="自动启动"><Row>
	<i-col span="11">
	<FormItem prop="autoStartMin">
	<InputNumber v-model="searchForm.autoStartMin" placeholder="请输入开始自动启动" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="autoStartMax">
	<InputNumber v-model="searchForm.autoStartMax" placeholder="请输入结束自动启动" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
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
      <p>作业编号: <span v-text="form.id"></span></p>
<p>作业名称: <span v-text="form.name"></span></p>
<p>完整类名: <span v-text="form.className"></span></p>
<p>cron表达式: <span v-text="form.cronExpression"></span></p>
<p>作业组名称: <span v-text="form.groupName"></span></p>
<p>触发器名称: <span v-text="form.triggerName"></span></p>
<p>触发器组: <span v-text="form.triggerGroup"></span></p>
<p>作业描述: <span v-text="form.description"></span></p>
<p>作业状态: <span v-text="form.jobStatus"></span></p>
<p>状态更新时间: <span v-text="form.jobStatusTime"></span></p>
<p>自动启动: <span v-text="form.autoStart"></span></p>
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
    name: 'SchedulerList',
    data() {
      return {
        modal: {
          add: false,
          edit: false,
          search: false,
          detail: false
        },
        urls: {
          searchUrl: '/scheduler/admin/pager-cond',
          allUrl: '/scheduler/admin/all',
          detailUrl: '/scheduler/admin/one/',
          multiUrl: '/scheduler/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
name: null,
className: null,
cronExpression: null,
groupName: null,
triggerName: null,
triggerGroup: null,
description: null,
jobStatus: null,
jobStatusTime: null,
autoStart: null,
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
name: null,
className: null,
cronExpression: null,
groupName: null,
triggerName: null,
triggerGroup: null,
description: null,
jobStatus: null,
jobStatusMin: null, 
jobStatusMax: null, 
jobStatusTime: null,
jobStatusTimeMin: null, 
jobStatusTimeMax: null, 
autoStart: null,
autoStartMin: null, 
autoStartMax: null, 
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
title: '作业编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '作业名称',
key: 'name',
minWidth: 120,
sortable: true
},
{
title: '完整类名',
key: 'className',
minWidth: 120,
sortable: true
},
{
title: 'cron表达式',
key: 'cronExpression',
minWidth: 120,
sortable: true
},
{
title: '作业组名称',
key: 'groupName',
minWidth: 120,
sortable: true
},
{
title: '触发器名称',
key: 'triggerName',
minWidth: 120,
sortable: true
},
{
title: '触发器组',
key: 'triggerGroup',
minWidth: 120,
sortable: true
},
{
title: '作业描述',
key: 'description',
minWidth: 120,
sortable: true
},
{
title: '作业状态',
key: 'jobStatus',
minWidth: 120,
sortable: true
},
{
title: '状态更新时间',
key: 'jobStatusTime',
minWidth: 120,
sortable: true
},
{
title: '自动启动',
key: 'autoStart',
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
