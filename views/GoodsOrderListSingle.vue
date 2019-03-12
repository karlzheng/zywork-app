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
          <Table highlight-row ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails" style="margin-top:20px;" @on-current-change="changeCurrent" @on-sort-change="changeSort"></Table>
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
<FormItem label="订单号" prop="orderNo">
	<Input v-model="searchForm.orderNo" placeholder="请输入订单号"/>
</FormItem>
<FormItem label="订单金额"><Row>
	<i-col span="11">
	<FormItem prop="totalAmountMin">
	<InputNumber v-model="searchForm.totalAmountMin" placeholder="请输入开始订单金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="totalAmountMax">
	<InputNumber v-model="searchForm.totalAmountMax" placeholder="请输入结束订单金额" style="width: 100%;"/>
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
<FormItem label="运费"><Row>
	<i-col span="11">
	<FormItem prop="expressFeeMin">
	<InputNumber v-model="searchForm.expressFeeMin" placeholder="请输入开始运费" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="expressFeeMax">
	<InputNumber v-model="searchForm.expressFeeMax" placeholder="请输入结束运费" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="订单状态"><Row>
	<i-col span="11">
	<FormItem prop="orderStatusMin">
	<InputNumber v-model="searchForm.orderStatusMin" placeholder="请输入开始订单状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="orderStatusMax">
	<InputNumber v-model="searchForm.orderStatusMax" placeholder="请输入结束订单状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="支付时间"><Row>
	<i-col span="11">
	<FormItem prop="payTimeMin">
	<DatePicker @on-change="searchForm.payTimeMin=$event" :value="searchForm.payTimeMin" placeholder="请输入开始支付时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="payTimeMax">
	<DatePicker @on-change="searchForm.payTimeMax=$event" :value="searchForm.payTimeMax" placeholder="请输入结束支付时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="支付方式"><Row>
	<i-col span="11">
	<FormItem prop="payTypeMin">
	<InputNumber v-model="searchForm.payTypeMin" placeholder="请输入开始支付方式" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="payTypeMax">
	<InputNumber v-model="searchForm.payTypeMax" placeholder="请输入结束支付方式" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="支付订单号" prop="transactionNo">
	<Input v-model="searchForm.transactionNo" placeholder="请输入支付订单号"/>
</FormItem>
<FormItem label="是否支付成功"><Row>
	<i-col span="11">
	<FormItem prop="paySuccessMin">
	<InputNumber v-model="searchForm.paySuccessMin" placeholder="请输入开始是否支付成功" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="paySuccessMax">
	<InputNumber v-model="searchForm.paySuccessMax" placeholder="请输入结束是否支付成功" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="发货时间"><Row>
	<i-col span="11">
	<FormItem prop="deliverTimeMin">
	<DatePicker @on-change="searchForm.deliverTimeMin=$event" :value="searchForm.deliverTimeMin" placeholder="请输入开始发货时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="deliverTimeMax">
	<DatePicker @on-change="searchForm.deliverTimeMax=$event" :value="searchForm.deliverTimeMax" placeholder="请输入结束发货时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="成交时间"><Row>
	<i-col span="11">
	<FormItem prop="dealTimeMin">
	<DatePicker @on-change="searchForm.dealTimeMin=$event" :value="searchForm.dealTimeMin" placeholder="请输入开始成交时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="dealTimeMax">
	<DatePicker @on-change="searchForm.dealTimeMax=$event" :value="searchForm.dealTimeMax" placeholder="请输入结束成交时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
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
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">确定</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>订单编号: <span v-text="form.id"></span></p>
<p>用户编号: <span v-text="form.userId"></span></p>
<p>订单号: <span v-text="form.orderNo"></span></p>
<p>订单金额: <span v-text="form.totalAmount"></span></p>
<p>实付金额: <span v-text="form.payAmount"></span></p>
<p>优惠金额: <span v-text="form.discountAmount"></span></p>
<p>赠送积分: <span v-text="form.integralAmount"></span></p>
<p>运费: <span v-text="form.expressFee"></span></p>
<p>订单状态: <span v-text="form.orderStatus"></span></p>
<p>支付时间: <span v-text="form.payTime"></span></p>
<p>支付方式: <span v-text="form.payType"></span></p>
<p>支付订单号: <span v-text="form.transactionNo"></span></p>
<p>是否支付成功: <span v-text="form.paySuccess"></span></p>
<p>发货时间: <span v-text="form.deliverTime"></span></p>
<p>成交时间: <span v-text="form.dealTime"></span></p>
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
    name: 'GoodsOrderListSingle',
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
          searchUrl: '/goods-order/admin/pager-cond',
          allUrl: '/goods-order/admin/all',
          detailUrl: '/goods-order/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
userId: null,
orderNo: null,
totalAmount: null,
payAmount: null,
discountAmount: null,
integralAmount: null,
expressFee: null,
orderStatus: null,
payTime: null,
payType: null,
transactionNo: null,
paySuccess: null,
deliverTime: null,
dealTime: null,
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
orderNo: null,
totalAmount: null,
totalAmountMin: null, 
totalAmountMax: null, 
payAmount: null,
payAmountMin: null, 
payAmountMax: null, 
discountAmount: null,
discountAmountMin: null, 
discountAmountMax: null, 
integralAmount: null,
integralAmountMin: null, 
integralAmountMax: null, 
expressFee: null,
expressFeeMin: null, 
expressFeeMax: null, 
orderStatus: null,
orderStatusMin: null, 
orderStatusMax: null, 
payTime: null,
payTimeMin: null, 
payTimeMax: null, 
payType: null,
payTypeMin: null, 
payTypeMax: null, 
transactionNo: null,
paySuccess: null,
paySuccessMin: null, 
paySuccessMax: null, 
deliverTime: null,
deliverTimeMin: null, 
deliverTimeMax: null, 
dealTime: null,
dealTimeMin: null, 
dealTimeMax: null, 
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
title: '用户编号',
key: 'userId',
minWidth: 120,
sortable: true
},
{
title: '订单号',
key: 'orderNo',
minWidth: 120,
sortable: true
},
{
title: '订单金额',
key: 'totalAmount',
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
title: '运费',
key: 'expressFee',
minWidth: 120,
sortable: true
},
{
title: '订单状态',
key: 'orderStatus',
minWidth: 120,
sortable: true
},
{
title: '支付时间',
key: 'payTime',
minWidth: 120,
sortable: true
},
{
title: '支付方式',
key: 'payType',
minWidth: 120,
sortable: true
},
{
title: '支付订单号',
key: 'transactionNo',
minWidth: 120,
sortable: true
},
{
title: '是否支付成功',
key: 'paySuccess',
minWidth: 120,
sortable: true
},
{
title: '发货时间',
key: 'deliverTime',
minWidth: 120,
sortable: true
},
{
title: '成交时间',
key: 'dealTime',
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
          currentRow: {}
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
      changeCurrent(currentRow, oldCurrentRow) {
        utils.changeCurrent(this, currentRow, oldCurrentRow)
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
