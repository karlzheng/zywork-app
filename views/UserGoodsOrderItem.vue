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
<FormItem label="昵称" prop="userDetailNickname">
	<Input v-model="searchForm.userDetailNickname" placeholder="请输入昵称"/>
</FormItem>
<FormItem label="头像地址" prop="userDetailHeadicon">
	<Input v-model="searchForm.userDetailHeadicon" placeholder="请输入头像地址"/>
</FormItem>
<FormItem label="订单编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderIdMin">
	<InputNumber v-model="searchForm.goodsOrderIdMin" placeholder="请输入开始订单编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderIdMax">
	<InputNumber v-model="searchForm.goodsOrderIdMax" placeholder="请输入结束订单编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="订单号" prop="goodsOrderOrderNo">
	<Input v-model="searchForm.goodsOrderOrderNo" placeholder="请输入订单号"/>
</FormItem>
<FormItem label="订单金额"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderTotalAmountMin">
	<InputNumber v-model="searchForm.goodsOrderTotalAmountMin" placeholder="请输入开始订单金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderTotalAmountMax">
	<InputNumber v-model="searchForm.goodsOrderTotalAmountMax" placeholder="请输入结束订单金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="实付金额"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderPayAmountMin">
	<InputNumber v-model="searchForm.goodsOrderPayAmountMin" placeholder="请输入开始实付金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderPayAmountMax">
	<InputNumber v-model="searchForm.goodsOrderPayAmountMax" placeholder="请输入结束实付金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="优惠金额"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderDiscountAmountMin">
	<InputNumber v-model="searchForm.goodsOrderDiscountAmountMin" placeholder="请输入开始优惠金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderDiscountAmountMax">
	<InputNumber v-model="searchForm.goodsOrderDiscountAmountMax" placeholder="请输入结束优惠金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="赠送积分"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderIntegralAmountMin">
	<InputNumber v-model="searchForm.goodsOrderIntegralAmountMin" placeholder="请输入开始赠送积分" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderIntegralAmountMax">
	<InputNumber v-model="searchForm.goodsOrderIntegralAmountMax" placeholder="请输入结束赠送积分" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="运费"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderExpressFeeMin">
	<InputNumber v-model="searchForm.goodsOrderExpressFeeMin" placeholder="请输入开始运费" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderExpressFeeMax">
	<InputNumber v-model="searchForm.goodsOrderExpressFeeMax" placeholder="请输入结束运费" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="订单状态"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderOrderStatusMin">
	<InputNumber v-model="searchForm.goodsOrderOrderStatusMin" placeholder="请输入开始订单状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderOrderStatusMax">
	<InputNumber v-model="searchForm.goodsOrderOrderStatusMax" placeholder="请输入结束订单状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="支付时间"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderPayTimeMin">
	<DatePicker @on-change="searchForm.goodsOrderPayTimeMin=$event" :value="searchForm.goodsOrderPayTimeMin" placeholder="请输入开始支付时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderPayTimeMax">
	<DatePicker @on-change="searchForm.goodsOrderPayTimeMax=$event" :value="searchForm.goodsOrderPayTimeMax" placeholder="请输入结束支付时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="支付方式"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderPayTypeMin">
	<InputNumber v-model="searchForm.goodsOrderPayTypeMin" placeholder="请输入开始支付方式" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderPayTypeMax">
	<InputNumber v-model="searchForm.goodsOrderPayTypeMax" placeholder="请输入结束支付方式" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="支付订单号" prop="goodsOrderTransactionNo">
	<Input v-model="searchForm.goodsOrderTransactionNo" placeholder="请输入支付订单号"/>
</FormItem>
<FormItem label="是否支付成功"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderPaySuccessMin">
	<InputNumber v-model="searchForm.goodsOrderPaySuccessMin" placeholder="请输入开始是否支付成功" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderPaySuccessMax">
	<InputNumber v-model="searchForm.goodsOrderPaySuccessMax" placeholder="请输入结束是否支付成功" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="发货时间"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderDeliverTimeMin">
	<DatePicker @on-change="searchForm.goodsOrderDeliverTimeMin=$event" :value="searchForm.goodsOrderDeliverTimeMin" placeholder="请输入开始发货时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderDeliverTimeMax">
	<DatePicker @on-change="searchForm.goodsOrderDeliverTimeMax=$event" :value="searchForm.goodsOrderDeliverTimeMax" placeholder="请输入结束发货时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="成交时间"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderDealTimeMin">
	<DatePicker @on-change="searchForm.goodsOrderDealTimeMin=$event" :value="searchForm.goodsOrderDealTimeMin" placeholder="请输入开始成交时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderDealTimeMax">
	<DatePicker @on-change="searchForm.goodsOrderDealTimeMax=$event" :value="searchForm.goodsOrderDealTimeMax" placeholder="请输入结束成交时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="商品编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderItemGoodsIdMin">
	<InputNumber v-model="searchForm.goodsOrderItemGoodsIdMin" placeholder="请输入开始商品编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderItemGoodsIdMax">
	<InputNumber v-model="searchForm.goodsOrderItemGoodsIdMax" placeholder="请输入结束商品编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="SKU编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderItemGoodsSkuIdMin">
	<InputNumber v-model="searchForm.goodsOrderItemGoodsSkuIdMin" placeholder="请输入开始SKU编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderItemGoodsSkuIdMax">
	<InputNumber v-model="searchForm.goodsOrderItemGoodsSkuIdMax" placeholder="请输入结束SKU编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="售卖标题" prop="goodsOrderItemSkuTitle">
	<Input v-model="searchForm.goodsOrderItemSkuTitle" placeholder="请输入售卖标题"/>
</FormItem>
<FormItem label="SKU属性JSON" prop="goodsOrderItemSkuInfo">
	<Input v-model="searchForm.goodsOrderItemSkuInfo" placeholder="请输入SKU属性JSON"/>
</FormItem>
<FormItem label="购买数量"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderItemQuantityMin">
	<InputNumber v-model="searchForm.goodsOrderItemQuantityMin" placeholder="请输入开始购买数量" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderItemQuantityMax">
	<InputNumber v-model="searchForm.goodsOrderItemQuantityMax" placeholder="请输入结束购买数量" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="实付金额"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderItemPayAmountMin">
	<InputNumber v-model="searchForm.goodsOrderItemPayAmountMin" placeholder="请输入开始实付金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderItemPayAmountMax">
	<InputNumber v-model="searchForm.goodsOrderItemPayAmountMax" placeholder="请输入结束实付金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="优惠金额"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderItemDiscountAmountMin">
	<InputNumber v-model="searchForm.goodsOrderItemDiscountAmountMin" placeholder="请输入开始优惠金额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderItemDiscountAmountMax">
	<InputNumber v-model="searchForm.goodsOrderItemDiscountAmountMax" placeholder="请输入结束优惠金额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="赠送积分"><Row>
	<i-col span="11">
	<FormItem prop="goodsOrderItemIntegralAmountMin">
	<InputNumber v-model="searchForm.goodsOrderItemIntegralAmountMin" placeholder="请输入开始赠送积分" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsOrderItemIntegralAmountMax">
	<InputNumber v-model="searchForm.goodsOrderItemIntegralAmountMax" placeholder="请输入结束赠送积分" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="商品图片编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsPicIdMin">
	<InputNumber v-model="searchForm.goodsPicIdMin" placeholder="请输入开始商品图片编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsPicIdMax">
	<InputNumber v-model="searchForm.goodsPicIdMax" placeholder="请输入结束商品图片编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="图片URL" prop="goodsPicPicUrl">
	<Input v-model="searchForm.goodsPicPicUrl" placeholder="请输入图片URL"/>
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
<p>昵称: <span v-text="form.userDetailNickname"></span></p>
<p>头像地址: <span v-text="form.userDetailHeadicon"></span></p>
<p>订单编号: <span v-text="form.goodsOrderId"></span></p>
<p>订单号: <span v-text="form.goodsOrderOrderNo"></span></p>
<p>订单金额: <span v-text="form.goodsOrderTotalAmount"></span></p>
<p>实付金额: <span v-text="form.goodsOrderPayAmount"></span></p>
<p>优惠金额: <span v-text="form.goodsOrderDiscountAmount"></span></p>
<p>赠送积分: <span v-text="form.goodsOrderIntegralAmount"></span></p>
<p>运费: <span v-text="form.goodsOrderExpressFee"></span></p>
<p>订单状态: <span v-text="form.goodsOrderOrderStatus"></span></p>
<p>支付时间: <span v-text="form.goodsOrderPayTime"></span></p>
<p>支付方式: <span v-text="form.goodsOrderPayType"></span></p>
<p>支付订单号: <span v-text="form.goodsOrderTransactionNo"></span></p>
<p>是否支付成功: <span v-text="form.goodsOrderPaySuccess"></span></p>
<p>发货时间: <span v-text="form.goodsOrderDeliverTime"></span></p>
<p>成交时间: <span v-text="form.goodsOrderDealTime"></span></p>
<p>商品编号: <span v-text="form.goodsOrderItemGoodsId"></span></p>
<p>SKU编号: <span v-text="form.goodsOrderItemGoodsSkuId"></span></p>
<p>售卖标题: <span v-text="form.goodsOrderItemSkuTitle"></span></p>
<p>SKU属性JSON: <span v-text="form.goodsOrderItemSkuInfo"></span></p>
<p>购买数量: <span v-text="form.goodsOrderItemQuantity"></span></p>
<p>实付金额: <span v-text="form.goodsOrderItemPayAmount"></span></p>
<p>优惠金额: <span v-text="form.goodsOrderItemDiscountAmount"></span></p>
<p>赠送积分: <span v-text="form.goodsOrderItemIntegralAmount"></span></p>
<p>商品图片编号: <span v-text="form.goodsPicId"></span></p>
<p>图片URL: <span v-text="form.goodsPicPicUrl"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'UserGoodsOrderItem',
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
          searchUrl: '/user-goods-order-item/admin/pager-cond',
          allUrl: '/user-goods-order-item/admin/all',
          detailUrl: '/user-goods-order-item/admin/one/',
          multiUrl: '/user-goods-order-item/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          userId: null,
userPhone: null,
userEmail: null,
userDetailNickname: null,
userDetailHeadicon: null,
goodsOrderId: null,
goodsOrderOrderNo: null,
goodsOrderTotalAmount: null,
goodsOrderPayAmount: null,
goodsOrderDiscountAmount: null,
goodsOrderIntegralAmount: null,
goodsOrderExpressFee: null,
goodsOrderOrderStatus: null,
goodsOrderPayTime: null,
goodsOrderPayType: null,
goodsOrderTransactionNo: null,
goodsOrderPaySuccess: null,
goodsOrderDeliverTime: null,
goodsOrderDealTime: null,
goodsOrderItemGoodsId: null,
goodsOrderItemGoodsSkuId: null,
goodsOrderItemSkuTitle: null,
goodsOrderItemSkuInfo: null,
goodsOrderItemQuantity: null,
goodsOrderItemPayAmount: null,
goodsOrderItemDiscountAmount: null,
goodsOrderItemIntegralAmount: null,
goodsPicId: null,
goodsPicPicUrl: null,

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
userDetailNickname: null,
userDetailHeadicon: null,
goodsOrderId: null,
goodsOrderIdMin: null, 
goodsOrderIdMax: null, 
goodsOrderOrderNo: null,
goodsOrderTotalAmount: null,
goodsOrderTotalAmountMin: null, 
goodsOrderTotalAmountMax: null, 
goodsOrderPayAmount: null,
goodsOrderPayAmountMin: null, 
goodsOrderPayAmountMax: null, 
goodsOrderDiscountAmount: null,
goodsOrderDiscountAmountMin: null, 
goodsOrderDiscountAmountMax: null, 
goodsOrderIntegralAmount: null,
goodsOrderIntegralAmountMin: null, 
goodsOrderIntegralAmountMax: null, 
goodsOrderExpressFee: null,
goodsOrderExpressFeeMin: null, 
goodsOrderExpressFeeMax: null, 
goodsOrderOrderStatus: null,
goodsOrderOrderStatusMin: null, 
goodsOrderOrderStatusMax: null, 
goodsOrderPayTime: null,
goodsOrderPayTimeMin: null, 
goodsOrderPayTimeMax: null, 
goodsOrderPayType: null,
goodsOrderPayTypeMin: null, 
goodsOrderPayTypeMax: null, 
goodsOrderTransactionNo: null,
goodsOrderPaySuccess: null,
goodsOrderPaySuccessMin: null, 
goodsOrderPaySuccessMax: null, 
goodsOrderDeliverTime: null,
goodsOrderDeliverTimeMin: null, 
goodsOrderDeliverTimeMax: null, 
goodsOrderDealTime: null,
goodsOrderDealTimeMin: null, 
goodsOrderDealTimeMax: null, 
goodsOrderItemGoodsId: null,
goodsOrderItemGoodsIdMin: null, 
goodsOrderItemGoodsIdMax: null, 
goodsOrderItemGoodsSkuId: null,
goodsOrderItemGoodsSkuIdMin: null, 
goodsOrderItemGoodsSkuIdMax: null, 
goodsOrderItemSkuTitle: null,
goodsOrderItemSkuInfo: null,
goodsOrderItemQuantity: null,
goodsOrderItemQuantityMin: null, 
goodsOrderItemQuantityMax: null, 
goodsOrderItemPayAmount: null,
goodsOrderItemPayAmountMin: null, 
goodsOrderItemPayAmountMax: null, 
goodsOrderItemDiscountAmount: null,
goodsOrderItemDiscountAmountMin: null, 
goodsOrderItemDiscountAmountMax: null, 
goodsOrderItemIntegralAmount: null,
goodsOrderItemIntegralAmountMin: null, 
goodsOrderItemIntegralAmountMax: null, 
goodsPicId: null,
goodsPicIdMin: null, 
goodsPicIdMax: null, 
goodsPicPicUrl: null,

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
title: '昵称',
key: 'userDetailNickname',
minWidth: 120,
sortable: true
},
{
title: '头像地址',
key: 'userDetailHeadicon',
minWidth: 120,
sortable: true
},
{
title: '订单编号',
key: 'goodsOrderId',
minWidth: 120,
sortable: true
},
{
title: '订单号',
key: 'goodsOrderOrderNo',
minWidth: 120,
sortable: true
},
{
title: '订单金额',
key: 'goodsOrderTotalAmount',
minWidth: 120,
sortable: true
},
{
title: '实付金额',
key: 'goodsOrderPayAmount',
minWidth: 120,
sortable: true
},
{
title: '优惠金额',
key: 'goodsOrderDiscountAmount',
minWidth: 120,
sortable: true
},
{
title: '赠送积分',
key: 'goodsOrderIntegralAmount',
minWidth: 120,
sortable: true
},
{
title: '运费',
key: 'goodsOrderExpressFee',
minWidth: 120,
sortable: true
},
{
title: '订单状态',
key: 'goodsOrderOrderStatus',
minWidth: 120,
sortable: true
},
{
title: '支付时间',
key: 'goodsOrderPayTime',
minWidth: 120,
sortable: true
},
{
title: '支付方式',
key: 'goodsOrderPayType',
minWidth: 120,
sortable: true
},
{
title: '支付订单号',
key: 'goodsOrderTransactionNo',
minWidth: 120,
sortable: true
},
{
title: '是否支付成功',
key: 'goodsOrderPaySuccess',
minWidth: 120,
sortable: true
},
{
title: '发货时间',
key: 'goodsOrderDeliverTime',
minWidth: 120,
sortable: true
},
{
title: '成交时间',
key: 'goodsOrderDealTime',
minWidth: 120,
sortable: true
},
{
title: '商品编号',
key: 'goodsOrderItemGoodsId',
minWidth: 120,
sortable: true
},
{
title: 'SKU编号',
key: 'goodsOrderItemGoodsSkuId',
minWidth: 120,
sortable: true
},
{
title: '售卖标题',
key: 'goodsOrderItemSkuTitle',
minWidth: 120,
sortable: true
},
{
title: 'SKU属性JSON',
key: 'goodsOrderItemSkuInfo',
minWidth: 120,
sortable: true
},
{
title: '购买数量',
key: 'goodsOrderItemQuantity',
minWidth: 120,
sortable: true
},
{
title: '实付金额',
key: 'goodsOrderItemPayAmount',
minWidth: 120,
sortable: true
},
{
title: '优惠金额',
key: 'goodsOrderItemDiscountAmount',
minWidth: 120,
sortable: true
},
{
title: '赠送积分',
key: 'goodsOrderItemIntegralAmount',
minWidth: 120,
sortable: true
},
{
title: '商品图片编号',
key: 'goodsPicId',
minWidth: 120,
sortable: true
},
{
title: '图片URL',
key: 'goodsPicPicUrl',
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
