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
        <FormItem label="模块标题" prop="moduleTitle">
	<Input v-model="searchForm.moduleTitle" placeholder="请输入模块标题"/>
</FormItem>
<FormItem label="模块描述" prop="moduleDescription">
	<Input v-model="searchForm.moduleDescription" placeholder="请输入模块描述"/>
</FormItem>
<FormItem label="权限编号"><Row>
	<i-col span="11">
	<FormItem prop="permissionIdMin">
	<InputNumber v-model="searchForm.permissionIdMin" placeholder="请输入开始权限编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="permissionIdMax">
	<InputNumber v-model="searchForm.permissionIdMax" placeholder="请输入结束权限编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="所属模块"><Row>
	<i-col span="11">
	<FormItem prop="permissionModuleIdMin">
	<InputNumber v-model="searchForm.permissionModuleIdMin" placeholder="请输入开始所属模块" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="permissionModuleIdMax">
	<InputNumber v-model="searchForm.permissionModuleIdMax" placeholder="请输入结束所属模块" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="权限标题" prop="permissionTitle">
	<Input v-model="searchForm.permissionTitle" placeholder="请输入权限标题"/>
</FormItem>
<FormItem label="权限字符串" prop="permissionPermission">
	<Input v-model="searchForm.permissionPermission" placeholder="请输入权限字符串"/>
</FormItem>
<FormItem label="权限描述" prop="permissionDescription">
	<Input v-model="searchForm.permissionDescription" placeholder="请输入权限描述"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="permissionVersionMin">
	<InputNumber v-model="searchForm.permissionVersionMin" placeholder="请输入开始版本号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="permissionVersionMax">
	<InputNumber v-model="searchForm.permissionVersionMax" placeholder="请输入结束版本号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="permissionCreateTimeMin">
	<DatePicker @on-change="searchForm.permissionCreateTimeMin=$event" :value="searchForm.permissionCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="permissionCreateTimeMax">
	<DatePicker @on-change="searchForm.permissionCreateTimeMax=$event" :value="searchForm.permissionCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="permissionUpdateTimeMin">
	<DatePicker @on-change="searchForm.permissionUpdateTimeMin=$event" :value="searchForm.permissionUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="permissionUpdateTimeMax">
	<DatePicker @on-change="searchForm.permissionUpdateTimeMax=$event" :value="searchForm.permissionUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="permissionIsActiveMin">
	<InputNumber v-model="searchForm.permissionIsActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="permissionIsActiveMax">
	<InputNumber v-model="searchForm.permissionIsActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
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
      <p>模块标题: <span v-text="form.moduleTitle"></span></p>
<p>模块描述: <span v-text="form.moduleDescription"></span></p>
<p>权限编号: <span v-text="form.permissionId"></span></p>
<p>所属模块: <span v-text="form.permissionModuleId"></span></p>
<p>权限标题: <span v-text="form.permissionTitle"></span></p>
<p>权限字符串: <span v-text="form.permissionPermission"></span></p>
<p>权限描述: <span v-text="form.permissionDescription"></span></p>
<p>版本号: <span v-text="form.permissionVersion"></span></p>
<p>创建时间: <span v-text="form.permissionCreateTime"></span></p>
<p>更新时间: <span v-text="form.permissionUpdateTime"></span></p>
<p>是否激活: <span v-text="form.permissionIsActive"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'ModulePermission',
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
          searchUrl: '/module-permission/admin/pager-cond',
          allUrl: '/module-permission/admin/all',
          detailUrl: '/module-permission/admin/one/',
          multiUrl: '/module-permission/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          moduleTitle: null,
moduleDescription: null,
permissionId: null,
permissionModuleId: null,
permissionTitle: null,
permissionPermission: null,
permissionDescription: null,
permissionVersion: null,
permissionCreateTime: null,
permissionUpdateTime: null,
permissionIsActive: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          moduleTitle: null,
moduleDescription: null,
permissionId: null,
permissionIdMin: null, 
permissionIdMax: null, 
permissionModuleId: null,
permissionModuleIdMin: null, 
permissionModuleIdMax: null, 
permissionTitle: null,
permissionPermission: null,
permissionDescription: null,
permissionVersion: null,
permissionVersionMin: null, 
permissionVersionMax: null, 
permissionCreateTime: null,
permissionCreateTimeMin: null, 
permissionCreateTimeMax: null, 
permissionUpdateTime: null,
permissionUpdateTimeMin: null, 
permissionUpdateTimeMax: null, 
permissionIsActive: null,
permissionIsActiveMin: null, 
permissionIsActiveMax: null, 

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
title: '模块标题',
key: 'moduleTitle',
minWidth: 120,
sortable: true
},
{
title: '模块描述',
key: 'moduleDescription',
minWidth: 120,
sortable: true
},
{
title: '权限编号',
key: 'permissionId',
minWidth: 120,
sortable: true
},
{
title: '所属模块',
key: 'permissionModuleId',
minWidth: 120,
sortable: true
},
{
title: '权限标题',
key: 'permissionTitle',
minWidth: 120,
sortable: true
},
{
title: '权限字符串',
key: 'permissionPermission',
minWidth: 120,
sortable: true
},
{
title: '权限描述',
key: 'permissionDescription',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'permissionVersion',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'permissionCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'permissionUpdateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'permissionIsActive',
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
