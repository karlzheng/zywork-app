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
        <FormItem label="订单编号" prop="orderId">
	<InputNumber v-model="form.orderId" placeholder="请输入订单编号" style="width: 100%;"/>
</FormItem>
<FormItem label="商品编号" prop="goodsId">
	<InputNumber v-model="form.goodsId" placeholder="请输入商品编号" style="width: 100%;"/>
</FormItem>
<FormItem label="SKU编号" prop="goodsSkuId">
	<InputNumber v-model="form.goodsSkuId" placeholder="请输入SKU编号" style="width: 100%;"/>
</FormItem>
<FormItem label="SKU图片编号" prop="skuPicId">
	<InputNumber v-model="form.skuPicId" placeholder="请输入SKU图片编号" style="width: 100%;"/>
</FormItem>
<FormItem label="售卖标题" prop="skuTitle">
	<Input v-model="form.skuTitle" placeholder="请输入售卖标题"/>
</FormItem>
<FormItem label="SKU属性JSON" prop="skuInfo">
	<Input v-model="form.skuInfo" placeholder="请输入SKU属性JSON"/>
</FormItem>
<FormItem label="购买数量" prop="quantity">
	<InputNumber v-model="form.quantity" placeholder="请输入购买数量" style="width: 100%;"/>
</FormItem>
<FormItem label="实付金额" prop="payAmount">
	<InputNumber v-model="form.payAmount" placeholder="请输入实付金额" style="width: 100%;"/>
</FormItem>
<FormItem label="优惠金额" prop="discountAmount">
	<InputNumber v-model="form.discountAmount" placeholder="请输入优惠金额" style="width: 100%;"/>
</FormItem>
<FormItem label="赠送积分" prop="integralAmount">
	<InputNumber v-model="form.integralAmount" placeholder="请输入赠送积分" style="width: 100%;"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="订单编号" prop="orderId">
	<InputNumber v-model="form.orderId" placeholder="请输入订单编号" style="width: 100%;"/>
</FormItem>
<FormItem label="商品编号" prop="goodsId">
	<InputNumber v-model="form.goodsId" placeholder="请输入商品编号" style="width: 100%;"/>
</FormItem>
<FormItem label="SKU编号" prop="goodsSkuId">
	<InputNumber v-model="form.goodsSkuId" placeholder="请输入SKU编号" style="width: 100%;"/>
</FormItem>
<FormItem label="SKU图片编号" prop="skuPicId">
	<InputNumber v-model="form.skuPicId" placeholder="请输入SKU图片编号" style="width: 100%;"/>
</FormItem>
<FormItem label="售卖标题" prop="skuTitle">
	<Input v-model="form.skuTitle" placeholder="请输入售卖标题"/>
</FormItem>
<FormItem label="SKU属性JSON" prop="skuInfo">
	<Input v-model="form.skuInfo" placeholder="请输入SKU属性JSON"/>
</FormItem>
<FormItem label="购买数量" prop="quantity">
	<InputNumber v-model="form.quantity" placeholder="请输入购买数量" style="width: 100%;"/>
</FormItem>
<FormItem label="实付金额" prop="payAmount">
	<InputNumber v-model="form.payAmount" placeholder="请输入实付金额" style="width: 100%;"/>
</FormItem>
<FormItem label="优惠金额" prop="discountAmount">
	<InputNumber v-model="form.discountAmount" placeholder="请输入优惠金额" style="width: 100%;"/>
</FormItem>
<FormItem label="赠送积分" prop="integralAmount">
	<InputNumber v-model="form.integralAmount" placeholder="请输入赠送积分" style="width: 100%;"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="订单项编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始订单项编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束订单项编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="订单编号"><Row>
	<i-col span="11">
	<FormItem prop="orderIdMin">
	<InputNumber v-model="searchForm.orderIdMin" placeholder="请输入开始订单编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="orderIdMax">
	<InputNumber v-model="searchForm.orderIdMax" placeholder="请输入结束订单编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="商品编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsIdMin">
	<InputNumber v-model="searchForm.goodsIdMin" placeholder="请输入开始商品编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsIdMax">
	<InputNumber v-model="searchForm.goodsIdMax" placeholder="请输入结束商品编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="SKU编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsSkuIdMin">
	<InputNumber v-model="searchForm.goodsSkuIdMin" placeholder="请输入开始SKU编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsSkuIdMax">
	<InputNumber v-model="searchForm.goodsSkuIdMax" placeholder="请输入结束SKU编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="SKU图片编号"><Row>
	<i-col span="11">
	<FormItem prop="skuPicIdMin">
	<InputNumber v-model="searchForm.skuPicIdMin" placeholder="请输入开始SKU图片编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="skuPicIdMax">
	<InputNumber v-model="searchForm.skuPicIdMax" placeholder="请输入结束SKU图片编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="售卖标题" prop="skuTitle">
	<Input v-model="searchForm.skuTitle" placeholder="请输入售卖标题"/>
</FormItem>
<FormItem label="SKU属性JSON" prop="skuInfo">
	<Input v-model="searchForm.skuInfo" placeholder="请输入SKU属性JSON"/>
</FormItem>
<FormItem label="购买数量"><Row>
	<i-col span="11">
	<FormItem prop="quantityMin">
	<InputNumber v-model="searchForm.quantityMin" placeholder="请输入开始购买数量" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="quantityMax">
	<InputNumber v-model="searchForm.quantityMax" placeholder="请输入结束购买数量" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="实付金额"><Row>
	<i-col span="11">
	<FormItem prop="payAmountMin">
	<InputNumber v-model="searchForm.payAmountMin" placeholder="请输入开始实付金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="payAmountMax">
	<InputNumber v-model="searchForm.payAmountMax" placeholder="请输入结束实付金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="优惠金额"><Row>
	<i-col span="11">
	<FormItem prop="discountAmountMin">
	<InputNumber v-model="searchForm.discountAmountMin" placeholder="请输入开始优惠金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="discountAmountMax">
	<InputNumber v-model="searchForm.discountAmountMax" placeholder="请输入结束优惠金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="赠送积分"><Row>
	<i-col span="11">
	<FormItem prop="integralAmountMin">
	<InputNumber v-model="searchForm.integralAmountMin" placeholder="请输入开始赠送积分" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="integralAmountMax">
	<InputNumber v-model="searchForm.integralAmountMax" placeholder="请输入结束赠送积分" style="width: 100%;"/>
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
      <p>订单项编号: <span v-text="form.id"></span></p>
<p>订单编号: <span v-text="form.orderId"></span></p>
<p>商品编号: <span v-text="form.goodsId"></span></p>
<p>SKU编号: <span v-text="form.goodsSkuId"></span></p>
<p>SKU图片编号: <span v-text="form.skuPicId"></span></p>
<p>售卖标题: <span v-text="form.skuTitle"></span></p>
<p>SKU属性JSON: <span v-text="form.skuInfo"></span></p>
<p>购买数量: <span v-text="form.quantity"></span></p>
<p>实付金额: <span v-text="form.payAmount"></span></p>
<p>优惠金额: <span v-text="form.discountAmount"></span></p>
<p>赠送积分: <span v-text="form.integralAmount"></span></p>
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
    name: 'GoodsOrderItem',
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
          addUrl: '/goods-order-item/admin/save',
          batchAddUrl: '/goods-order-item/admin/batch-save',
          editUrl: '/goods-order-item/admin/update',
          batchEditUrl: '/goods-order-item/admin/batch-update',
          searchUrl: '/goods-order-item/admin/pager-cond',
          allUrl: '/goods-order-item/admin/all',
          removeUrl: '/goods-order-item/admin/remove/',
          batchRemoveUrl: '/goods-order-item/admin/batch-remove',
          detailUrl: '/goods-order-item/admin/one/',
          activeUrl: '/goods-order-item/admin/active',
          batchActiveUrl: '/goods-order-item/admin/batch-active'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
orderId: null,
goodsId: null,
goodsSkuId: null,
skuPicId: null,
skuTitle: null,
skuInfo: null,
quantity: null,
payAmount: null,
discountAmount: null,
integralAmount: null,
version: null,
createTime: null,
updateTime: null,
isActive: null,

        },
        validateRules: {
          orderId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
goodsId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
goodsSkuId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
skuPicId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
skuTitle: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 255, message: '必须1-255个字符', trigger: 'blur'}
],
skuInfo: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
quantity: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
payAmount: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
discountAmount: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
integralAmount: [
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
orderId: null,
orderIdMin: null, 
orderIdMax: null, 
goodsId: null,
goodsIdMin: null, 
goodsIdMax: null, 
goodsSkuId: null,
goodsSkuIdMin: null, 
goodsSkuIdMax: null, 
skuPicId: null,
skuPicIdMin: null, 
skuPicIdMax: null, 
skuTitle: null,
skuInfo: null,
quantity: null,
quantityMin: null, 
quantityMax: null, 
payAmount: null,
payAmountMin: null, 
payAmountMax: null, 
discountAmount: null,
discountAmountMin: null, 
discountAmountMax: null, 
integralAmount: null,
integralAmountMin: null, 
integralAmountMax: null, 
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
title: '订单项编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '订单编号',
key: 'orderId',
minWidth: 120,
sortable: true
},
{
title: '商品编号',
key: 'goodsId',
minWidth: 120,
sortable: true
},
{
title: 'SKU编号',
key: 'goodsSkuId',
minWidth: 120,
sortable: true
},
{
title: 'SKU图片编号',
key: 'skuPicId',
minWidth: 120,
sortable: true
},
{
title: '售卖标题',
key: 'skuTitle',
minWidth: 120,
sortable: true
},
{
title: 'SKU属性JSON',
key: 'skuInfo',
minWidth: 120,
sortable: true
},
{
title: '购买数量',
key: 'quantity',
minWidth: 120,
sortable: true
},
{
title: '实付金额',
key: 'payAmount',
minWidth: 120,
sortable: true
},
{
title: '优惠金额',
key: 'discountAmount',
minWidth: 120,
sortable: true
},
{
title: '赠送积分',
key: 'integralAmount',
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
