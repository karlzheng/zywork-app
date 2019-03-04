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
        <FormItem label="角色编号"><Row>
	<i-col span="11">
	<FormItem prop="roleIdMin">
	<InputNumber v-model="searchForm.roleIdMin" placeholder="请输入开始角色编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="roleIdMax">
	<InputNumber v-model="searchForm.roleIdMax" placeholder="请输入结束角色编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="角色标题" prop="roleTitle">
	<Input v-model="searchForm.roleTitle" placeholder="请输入角色标题"/>
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
<FormItem label="权限标题" prop="permissionTitle">
	<Input v-model="searchForm.permissionTitle" placeholder="请输入权限标题"/>
</FormItem>
<FormItem label="权限字符串" prop="permissionPermission">
	<Input v-model="searchForm.permissionPermission" placeholder="请输入权限字符串"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>角色编号: <span v-text="form.roleId"></span></p>
<p>角色标题: <span v-text="form.roleTitle"></span></p>
<p>权限编号: <span v-text="form.permissionId"></span></p>
<p>权限标题: <span v-text="form.permissionTitle"></span></p>
<p>权限字符串: <span v-text="form.permissionPermission"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'RolePermission',
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
          searchUrl: '/role-permission/admin/pager-cond',
          allUrl: '/role-permission/admin/all',
          detailUrl: '/role-permission/admin/one/',
          multiUrl: '/role-permission/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          roleId: null,
roleTitle: null,
permissionId: null,
permissionTitle: null,
permissionPermission: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          roleId: null,
roleIdMin: null, 
roleIdMax: null, 
roleTitle: null,
permissionId: null,
permissionIdMin: null, 
permissionIdMax: null, 
permissionTitle: null,
permissionPermission: null,

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
title: '角色编号',
key: 'roleId',
minWidth: 120,
sortable: true
},
{
title: '角色标题',
key: 'roleTitle',
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
