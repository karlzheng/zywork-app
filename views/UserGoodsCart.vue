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
<FormItem label="商品编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsSkuGoodsIdMin">
	<InputNumber v-model="searchForm.goodsSkuGoodsIdMin" placeholder="请输入开始商品编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsSkuGoodsIdMax">
	<InputNumber v-model="searchForm.goodsSkuGoodsIdMax" placeholder="请输入结束商品编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="图片URL" prop="goodsPicPicUrl">
	<Input v-model="searchForm.goodsPicPicUrl" placeholder="请输入图片URL"/>
</FormItem>
<FormItem label="购买数量"><Row>
	<i-col span="11">
	<FormItem prop="goodsCartQuantityMin">
	<InputNumber v-model="searchForm.goodsCartQuantityMin" placeholder="请输入开始购买数量" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsCartQuantityMax">
	<InputNumber v-model="searchForm.goodsCartQuantityMax" placeholder="请输入结束购买数量" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="goodsCartCreateTimeMin">
	<DatePicker @on-change="searchForm.goodsCartCreateTimeMin=$event" :value="searchForm.goodsCartCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsCartCreateTimeMax">
	<DatePicker @on-change="searchForm.goodsCartCreateTimeMax=$event" :value="searchForm.goodsCartCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="goodsCartUpdateTimeMin">
	<DatePicker @on-change="searchForm.goodsCartUpdateTimeMin=$event" :value="searchForm.goodsCartUpdateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsCartUpdateTimeMax">
	<DatePicker @on-change="searchForm.goodsCartUpdateTimeMax=$event" :value="searchForm.goodsCartUpdateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
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
      <p>用户编号: <span v-text="form.userId"></span></p>
<p>手机号: <span v-text="form.userPhone"></span></p>
<p>用户邮箱: <span v-text="form.userEmail"></span></p>
<p>昵称: <span v-text="form.userDetailNickname"></span></p>
<p>头像地址: <span v-text="form.userDetailHeadicon"></span></p>
<p>SKU编号: <span v-text="form.goodsSkuId"></span></p>
<p>商品编号: <span v-text="form.goodsSkuGoodsId"></span></p>
<p>图片URL: <span v-text="form.goodsPicPicUrl"></span></p>
<p>购买数量: <span v-text="form.goodsCartQuantity"></span></p>
<p>创建时间: <span v-text="form.goodsCartCreateTime"></span></p>
<p>更新时间: <span v-text="form.goodsCartUpdateTime"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'UserGoodsCart',
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
          searchUrl: '/user-goods-cart/admin/pager-cond',
          allUrl: '/user-goods-cart/admin/all',
          detailUrl: '/user-goods-cart/admin/one/',
          multiUrl: '/user-goods-cart/admin/multi/'
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
goodsSkuId: null,
goodsSkuGoodsId: null,
goodsPicPicUrl: null,
goodsCartQuantity: null,
goodsCartCreateTime: null,
goodsCartUpdateTime: null,

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
goodsSkuId: null,
goodsSkuIdMin: null, 
goodsSkuIdMax: null, 
goodsSkuGoodsId: null,
goodsSkuGoodsIdMin: null, 
goodsSkuGoodsIdMax: null, 
goodsPicPicUrl: null,
goodsCartQuantity: null,
goodsCartQuantityMin: null, 
goodsCartQuantityMax: null, 
goodsCartCreateTime: null,
goodsCartCreateTimeMin: null, 
goodsCartCreateTimeMax: null, 
goodsCartUpdateTime: null,
goodsCartUpdateTimeMin: null, 
goodsCartUpdateTimeMax: null, 

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
title: 'SKU编号',
key: 'goodsSkuId',
minWidth: 120,
sortable: true
},
{
title: '商品编号',
key: 'goodsSkuGoodsId',
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
title: '购买数量',
key: 'goodsCartQuantity',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'goodsCartCreateTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'goodsCartUpdateTime',
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
