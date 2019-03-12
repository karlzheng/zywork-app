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
        <FormItem label="收货人" prop="realName">
	<Input v-model="form.realName" placeholder="请输入收货人"/>
</FormItem>
<FormItem label="手机号" prop="phone">
	<Input v-model="form.phone" placeholder="请输入手机号"/>
</FormItem>
<FormItem label="省" prop="province">
	<Input v-model="form.province" placeholder="请输入省"/>
</FormItem>
<FormItem label="市" prop="city">
	<Input v-model="form.city" placeholder="请输入市"/>
</FormItem>
<FormItem label="区/县" prop="district">
	<Input v-model="form.district" placeholder="请输入区/县"/>
</FormItem>
<FormItem label="详细地址" prop="address">
	<Input v-model="form.address" placeholder="请输入详细地址"/>
</FormItem>
<FormItem label="是否已发货" prop="isDeliver">
	<InputNumber v-model="form.isDeliver" placeholder="请输入是否已发货" style="width: 100%;"/>
</FormItem>
<FormItem label="物流公司名称" prop="logisticsCompany">
	<Input v-model="form.logisticsCompany" placeholder="请输入物流公司名称"/>
</FormItem>
<FormItem label="物流公司编码" prop="logisticsCode">
	<Input v-model="form.logisticsCode" placeholder="请输入物流公司编码"/>
</FormItem>
<FormItem label="物流单号" prop="logisticsNo">
	<Input v-model="form.logisticsNo" placeholder="请输入物流单号"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="收货人" prop="realName">
	<Input v-model="form.realName" placeholder="请输入收货人"/>
</FormItem>
<FormItem label="手机号" prop="phone">
	<Input v-model="form.phone" placeholder="请输入手机号"/>
</FormItem>
<FormItem label="省" prop="province">
	<Input v-model="form.province" placeholder="请输入省"/>
</FormItem>
<FormItem label="市" prop="city">
	<Input v-model="form.city" placeholder="请输入市"/>
</FormItem>
<FormItem label="区/县" prop="district">
	<Input v-model="form.district" placeholder="请输入区/县"/>
</FormItem>
<FormItem label="详细地址" prop="address">
	<Input v-model="form.address" placeholder="请输入详细地址"/>
</FormItem>
<FormItem label="是否已发货" prop="isDeliver">
	<InputNumber v-model="form.isDeliver" placeholder="请输入是否已发货" style="width: 100%;"/>
</FormItem>
<FormItem label="物流公司名称" prop="logisticsCompany">
	<Input v-model="form.logisticsCompany" placeholder="请输入物流公司名称"/>
</FormItem>
<FormItem label="物流公司编码" prop="logisticsCode">
	<Input v-model="form.logisticsCode" placeholder="请输入物流公司编码"/>
</FormItem>
<FormItem label="物流单号" prop="logisticsNo">
	<Input v-model="form.logisticsNo" placeholder="请输入物流单号"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="订单编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始订单编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束订单编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="收货人" prop="realName">
	<Input v-model="searchForm.realName" placeholder="请输入收货人"/>
</FormItem>
<FormItem label="手机号" prop="phone">
	<Input v-model="searchForm.phone" placeholder="请输入手机号"/>
</FormItem>
<FormItem label="省" prop="province">
	<Input v-model="searchForm.province" placeholder="请输入省"/>
</FormItem>
<FormItem label="市" prop="city">
	<Input v-model="searchForm.city" placeholder="请输入市"/>
</FormItem>
<FormItem label="区/县" prop="district">
	<Input v-model="searchForm.district" placeholder="请输入区/县"/>
</FormItem>
<FormItem label="详细地址" prop="address">
	<Input v-model="searchForm.address" placeholder="请输入详细地址"/>
</FormItem>
<FormItem label="是否已发货"><Row>
	<i-col span="11">
	<FormItem prop="isDeliverMin">
	<InputNumber v-model="searchForm.isDeliverMin" placeholder="请输入开始是否已发货" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isDeliverMax">
	<InputNumber v-model="searchForm.isDeliverMax" placeholder="请输入结束是否已发货" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="物流公司名称" prop="logisticsCompany">
	<Input v-model="searchForm.logisticsCompany" placeholder="请输入物流公司名称"/>
</FormItem>
<FormItem label="物流公司编码" prop="logisticsCode">
	<Input v-model="searchForm.logisticsCode" placeholder="请输入物流公司编码"/>
</FormItem>
<FormItem label="物流单号" prop="logisticsNo">
	<Input v-model="searchForm.logisticsNo" placeholder="请输入物流单号"/>
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
      <p>订单编号: <span v-text="form.id"></span></p>
<p>收货人: <span v-text="form.realName"></span></p>
<p>手机号: <span v-text="form.phone"></span></p>
<p>省: <span v-text="form.province"></span></p>
<p>市: <span v-text="form.city"></span></p>
<p>区/县: <span v-text="form.district"></span></p>
<p>详细地址: <span v-text="form.address"></span></p>
<p>是否已发货: <span v-text="form.isDeliver"></span></p>
<p>物流公司名称: <span v-text="form.logisticsCompany"></span></p>
<p>物流公司编码: <span v-text="form.logisticsCode"></span></p>
<p>物流单号: <span v-text="form.logisticsNo"></span></p>
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
    name: 'GoodsOrderLogistics',
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
          addUrl: '/goods-order-logistics/admin/save',
          batchAddUrl: '/goods-order-logistics/admin/batch-save',
          editUrl: '/goods-order-logistics/admin/update',
          batchEditUrl: '/goods-order-logistics/admin/batch-update',
          searchUrl: '/goods-order-logistics/admin/pager-cond',
          allUrl: '/goods-order-logistics/admin/all',
          removeUrl: '/goods-order-logistics/admin/remove/',
          batchRemoveUrl: '/goods-order-logistics/admin/batch-remove',
          detailUrl: '/goods-order-logistics/admin/one/',
          activeUrl: '/goods-order-logistics/admin/active',
          batchActiveUrl: '/goods-order-logistics/admin/batch-active'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
realName: null,
phone: null,
province: null,
city: null,
district: null,
address: null,
isDeliver: null,
logisticsCompany: null,
logisticsCode: null,
logisticsNo: null,
version: null,
createTime: null,
updateTime: null,
isActive: null,

        },
        validateRules: {
          realName: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
phone: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 11, message: '必须1-11个字符', trigger: 'blur'}
],
province: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
city: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
district: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
address: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 255, message: '必须1-255个字符', trigger: 'blur'}
],
logisticsCompany: [
{type: 'string', min: 1, max: 255, message: '必须1-255个字符', trigger: 'blur'}
],
logisticsCode: [
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
logisticsNo: [
{type: 'string', min: 1, max: 32, message: '必须1-32个字符', trigger: 'blur'}
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
realName: null,
phone: null,
province: null,
city: null,
district: null,
address: null,
isDeliver: null,
isDeliverMin: null, 
isDeliverMax: null, 
logisticsCompany: null,
logisticsCode: null,
logisticsNo: null,
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
title: '订单编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '收货人',
key: 'realName',
minWidth: 120,
sortable: true
},
{
title: '手机号',
key: 'phone',
minWidth: 120,
sortable: true
},
{
title: '省',
key: 'province',
minWidth: 120,
sortable: true
},
{
title: '市',
key: 'city',
minWidth: 120,
sortable: true
},
{
title: '区/县',
key: 'district',
minWidth: 120,
sortable: true
},
{
title: '详细地址',
key: 'address',
minWidth: 120,
sortable: true
},
{
title: '是否已发货',
key: 'isDeliver',
minWidth: 120,
sortable: true
},
{
title: '物流公司名称',
key: 'logisticsCompany',
minWidth: 120,
sortable: true
},
{
title: '物流公司编码',
key: 'logisticsCode',
minWidth: 120,
sortable: true
},
{
title: '物流单号',
key: 'logisticsNo',
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
