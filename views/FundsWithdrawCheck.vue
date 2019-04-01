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
        <FormItem label="提现编号" prop="withdrawId">
	<InputNumber v-model="form.withdrawId" placeholder="请输入提现编号" style="width: 100%;"/>
</FormItem>
<FormItem label="交易编号" prop="transactionNo">
	<Input v-model="form.transactionNo" placeholder="请输入交易编号"/>
</FormItem>
<FormItem label="提现状态" prop="withdrawStatus">
	<InputNumber v-model="form.withdrawStatus" placeholder="请输入提现状态" style="width: 100%;"/>
</FormItem>
<FormItem label="提现描述" prop="withdrawDescription">
	<Input v-model="form.withdrawDescription" placeholder="请输入提现描述"/>
</FormItem>
<FormItem label="审核人编号" prop="checkedUserId">
	<InputNumber v-model="form.checkedUserId" placeholder="请输入审核人编号" style="width: 100%;"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="提现编号" prop="withdrawId">
	<InputNumber v-model="form.withdrawId" placeholder="请输入提现编号" style="width: 100%;"/>
</FormItem>
<FormItem label="交易编号" prop="transactionNo">
	<Input v-model="form.transactionNo" placeholder="请输入交易编号"/>
</FormItem>
<FormItem label="提现状态" prop="withdrawStatus">
	<InputNumber v-model="form.withdrawStatus" placeholder="请输入提现状态" style="width: 100%;"/>
</FormItem>
<FormItem label="提现描述" prop="withdrawDescription">
	<Input v-model="form.withdrawDescription" placeholder="请输入提现描述"/>
</FormItem>
<FormItem label="审核人编号" prop="checkedUserId">
	<InputNumber v-model="form.checkedUserId" placeholder="请输入审核人编号" style="width: 100%;"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="提现审核编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始提现审核编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束提现审核编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提现编号"><Row>
	<i-col span="11">
	<FormItem prop="withdrawIdMin">
	<InputNumber v-model="searchForm.withdrawIdMin" placeholder="请输入开始提现编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="withdrawIdMax">
	<InputNumber v-model="searchForm.withdrawIdMax" placeholder="请输入结束提现编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="交易编号" prop="transactionNo">
	<Input v-model="searchForm.transactionNo" placeholder="请输入交易编号"/>
</FormItem>
<FormItem label="提现状态"><Row>
	<i-col span="11">
	<FormItem prop="withdrawStatusMin">
	<InputNumber v-model="searchForm.withdrawStatusMin" placeholder="请输入开始提现状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="withdrawStatusMax">
	<InputNumber v-model="searchForm.withdrawStatusMax" placeholder="请输入结束提现状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提现描述" prop="withdrawDescription">
	<Input v-model="searchForm.withdrawDescription" placeholder="请输入提现描述"/>
</FormItem>
<FormItem label="审核人编号"><Row>
	<i-col span="11">
	<FormItem prop="checkedUserIdMin">
	<InputNumber v-model="searchForm.checkedUserIdMin" placeholder="请输入开始审核人编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="checkedUserIdMax">
	<InputNumber v-model="searchForm.checkedUserIdMax" placeholder="请输入结束审核人编号" style="width: 100%;"/>
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
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <p>提现审核编号: <span v-text="form.id"></span></p>
<p>提现编号: <span v-text="form.withdrawId"></span></p>
<p>交易编号: <span v-text="form.transactionNo"></span></p>
<p>提现状态: <span v-text="form.withdrawStatus"></span></p>
<p>提现描述: <span v-text="form.withdrawDescription"></span></p>
<p>审核人编号: <span v-text="form.checkedUserId"></span></p>
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
    name: 'FundsWithdrawCheck',
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
          addUrl: '/funds-withdraw-check/admin/save',
          batchAddUrl: '/funds-withdraw-check/admin/batch-save',
          editUrl: '/funds-withdraw-check/admin/update',
          batchEditUrl: '/funds-withdraw-check/admin/batch-update',
          searchUrl: '/funds-withdraw-check/admin/pager-cond',
          allUrl: '/funds-withdraw-check/admin/all',
          removeUrl: '/funds-withdraw-check/admin/remove/',
          batchRemoveUrl: '/funds-withdraw-check/admin/batch-remove',
          detailUrl: '/funds-withdraw-check/admin/one/',
          activeUrl: '/funds-withdraw-check/admin/active',
          batchActiveUrl: '/funds-withdraw-check/admin/batch-active'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
withdrawId: null,
transactionNo: null,
withdrawStatus: null,
withdrawDescription: null,
checkedUserId: null,
version: null,
createTime: null,
updateTime: null,
isActive: null,

        },
        validateRules: {
          withdrawId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
transactionNo: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 32, message: '必须1-32个字符', trigger: 'blur'}
],
withdrawStatus: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
withdrawDescription: [
{type: 'string', min: 1, max: 255, message: '必须1-255个字符', trigger: 'blur'}
],
checkedUserId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
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
withdrawId: null,
withdrawIdMin: null, 
withdrawIdMax: null, 
transactionNo: null,
withdrawStatus: null,
withdrawStatusMin: null, 
withdrawStatusMax: null, 
withdrawDescription: null,
checkedUserId: null,
checkedUserIdMin: null, 
checkedUserIdMax: null, 
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
title: '提现审核编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '提现编号',
key: 'withdrawId',
minWidth: 120,
sortable: true
},
{
title: '交易编号',
key: 'transactionNo',
minWidth: 120,
sortable: true
},
{
title: '提现状态',
key: 'withdrawStatus',
minWidth: 120,
sortable: true
},
{
title: '提现描述',
key: 'withdrawDescription',
minWidth: 120,
sortable: true
},
{
title: '审核人编号',
key: 'checkedUserId',
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
