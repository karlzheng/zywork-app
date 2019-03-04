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
        <FormItem label="商品编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsInfoIdMin">
	<InputNumber v-model="searchForm.goodsInfoIdMin" placeholder="请输入开始商品编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsInfoIdMax">
	<InputNumber v-model="searchForm.goodsInfoIdMax" placeholder="请输入结束商品编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="店铺编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsInfoShopIdMin">
	<InputNumber v-model="searchForm.goodsInfoShopIdMin" placeholder="请输入开始店铺编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsInfoShopIdMax">
	<InputNumber v-model="searchForm.goodsInfoShopIdMax" placeholder="请输入结束店铺编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="类目编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsInfoCategoryIdMin">
	<InputNumber v-model="searchForm.goodsInfoCategoryIdMin" placeholder="请输入开始类目编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsInfoCategoryIdMax">
	<InputNumber v-model="searchForm.goodsInfoCategoryIdMax" placeholder="请输入结束类目编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="上架状态"><Row>
	<i-col span="11">
	<FormItem prop="goodsInfoShelfStatusMin">
	<InputNumber v-model="searchForm.goodsInfoShelfStatusMin" placeholder="请输入开始上架状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsInfoShelfStatusMax">
	<InputNumber v-model="searchForm.goodsInfoShelfStatusMax" placeholder="请输入结束上架状态" style="width: 100%;"/>
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
<FormItem label="上架状态"><Row>
	<i-col span="11">
	<FormItem prop="goodsSkuShelfStatusMin">
	<InputNumber v-model="searchForm.goodsSkuShelfStatusMin" placeholder="请输入开始上架状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsSkuShelfStatusMax">
	<InputNumber v-model="searchForm.goodsSkuShelfStatusMax" placeholder="请输入结束上架状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="属性编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsCategoryAttributeAttrIdMin">
	<InputNumber v-model="searchForm.goodsCategoryAttributeAttrIdMin" placeholder="请输入开始属性编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsCategoryAttributeAttrIdMax">
	<InputNumber v-model="searchForm.goodsCategoryAttributeAttrIdMax" placeholder="请输入结束属性编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="属性排序"><Row>
	<i-col span="11">
	<FormItem prop="goodsCategoryAttributeAttrOrderMin">
	<InputNumber v-model="searchForm.goodsCategoryAttributeAttrOrderMin" placeholder="请输入开始属性排序" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsCategoryAttributeAttrOrderMax">
	<InputNumber v-model="searchForm.goodsCategoryAttributeAttrOrderMax" placeholder="请输入结束属性排序" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="属性名称" prop="goodsAttributeAttrName">
	<Input v-model="searchForm.goodsAttributeAttrName" placeholder="请输入属性名称"/>
</FormItem>
<FormItem label="属性代码" prop="goodsAttributeAttrCode">
	<Input v-model="searchForm.goodsAttributeAttrCode" placeholder="请输入属性代码"/>
</FormItem>
<FormItem label="数据类型" prop="goodsAttributeAttrType">
	<Input v-model="searchForm.goodsAttributeAttrType" placeholder="请输入数据类型"/>
</FormItem>
<FormItem label="数据长度"><Row>
	<i-col span="11">
	<FormItem prop="goodsAttributeAttrLengthMin">
	<InputNumber v-model="searchForm.goodsAttributeAttrLengthMin" placeholder="请输入开始数据长度" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsAttributeAttrLengthMax">
	<InputNumber v-model="searchForm.goodsAttributeAttrLengthMax" placeholder="请输入结束数据长度" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否必填"><Row>
	<i-col span="11">
	<FormItem prop="goodsAttributeAttrRequiredMin">
	<InputNumber v-model="searchForm.goodsAttributeAttrRequiredMin" placeholder="请输入开始是否必填" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsAttributeAttrRequiredMax">
	<InputNumber v-model="searchForm.goodsAttributeAttrRequiredMax" placeholder="请输入结束是否必填" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否前端显示"><Row>
	<i-col span="11">
	<FormItem prop="goodsAttributeAttrDisplayMin">
	<InputNumber v-model="searchForm.goodsAttributeAttrDisplayMin" placeholder="请输入开始是否前端显示" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsAttributeAttrDisplayMax">
	<InputNumber v-model="searchForm.goodsAttributeAttrDisplayMax" placeholder="请输入结束是否前端显示" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="属性值" prop="goodsAttributeValueAttrValue">
	<Input v-model="searchForm.goodsAttributeValueAttrValue" placeholder="请输入属性值"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>商品编号: <span v-text="form.goodsInfoId"></span></p>
<p>店铺编号: <span v-text="form.goodsInfoShopId"></span></p>
<p>类目编号: <span v-text="form.goodsInfoCategoryId"></span></p>
<p>上架状态: <span v-text="form.goodsInfoShelfStatus"></span></p>
<p>SKU编号: <span v-text="form.goodsSkuId"></span></p>
<p>上架状态: <span v-text="form.goodsSkuShelfStatus"></span></p>
<p>属性编号: <span v-text="form.goodsCategoryAttributeAttrId"></span></p>
<p>属性排序: <span v-text="form.goodsCategoryAttributeAttrOrder"></span></p>
<p>属性名称: <span v-text="form.goodsAttributeAttrName"></span></p>
<p>属性代码: <span v-text="form.goodsAttributeAttrCode"></span></p>
<p>数据类型: <span v-text="form.goodsAttributeAttrType"></span></p>
<p>数据长度: <span v-text="form.goodsAttributeAttrLength"></span></p>
<p>是否必填: <span v-text="form.goodsAttributeAttrRequired"></span></p>
<p>是否前端显示: <span v-text="form.goodsAttributeAttrDisplay"></span></p>
<p>属性值: <span v-text="form.goodsAttributeValueAttrValue"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'GoodsSkuAttributeValue',
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
          searchUrl: '/goods-sku-attr-val/admin/pager-cond',
          allUrl: '/goods-sku-attr-val/admin/all',
          detailUrl: '/goods-sku-attr-val/admin/one/',
          multiUrl: '/goods-sku-attr-val/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          goodsInfoId: null,
goodsInfoShopId: null,
goodsInfoCategoryId: null,
goodsInfoShelfStatus: null,
goodsSkuId: null,
goodsSkuShelfStatus: null,
goodsCategoryAttributeAttrId: null,
goodsCategoryAttributeAttrOrder: null,
goodsAttributeAttrName: null,
goodsAttributeAttrCode: null,
goodsAttributeAttrType: null,
goodsAttributeAttrLength: null,
goodsAttributeAttrRequired: null,
goodsAttributeAttrDisplay: null,
goodsAttributeValueAttrValue: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          goodsInfoId: null,
goodsInfoIdMin: null, 
goodsInfoIdMax: null, 
goodsInfoShopId: null,
goodsInfoShopIdMin: null, 
goodsInfoShopIdMax: null, 
goodsInfoCategoryId: null,
goodsInfoCategoryIdMin: null, 
goodsInfoCategoryIdMax: null, 
goodsInfoShelfStatus: null,
goodsInfoShelfStatusMin: null, 
goodsInfoShelfStatusMax: null, 
goodsSkuId: null,
goodsSkuIdMin: null, 
goodsSkuIdMax: null, 
goodsSkuShelfStatus: null,
goodsSkuShelfStatusMin: null, 
goodsSkuShelfStatusMax: null, 
goodsCategoryAttributeAttrId: null,
goodsCategoryAttributeAttrIdMin: null, 
goodsCategoryAttributeAttrIdMax: null, 
goodsCategoryAttributeAttrOrder: null,
goodsCategoryAttributeAttrOrderMin: null, 
goodsCategoryAttributeAttrOrderMax: null, 
goodsAttributeAttrName: null,
goodsAttributeAttrCode: null,
goodsAttributeAttrType: null,
goodsAttributeAttrLength: null,
goodsAttributeAttrLengthMin: null, 
goodsAttributeAttrLengthMax: null, 
goodsAttributeAttrRequired: null,
goodsAttributeAttrRequiredMin: null, 
goodsAttributeAttrRequiredMax: null, 
goodsAttributeAttrDisplay: null,
goodsAttributeAttrDisplayMin: null, 
goodsAttributeAttrDisplayMax: null, 
goodsAttributeValueAttrValue: null,

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
title: '商品编号',
key: 'goodsInfoId',
minWidth: 120,
sortable: true
},
{
title: '店铺编号',
key: 'goodsInfoShopId',
minWidth: 120,
sortable: true
},
{
title: '类目编号',
key: 'goodsInfoCategoryId',
minWidth: 120,
sortable: true
},
{
title: '上架状态',
key: 'goodsInfoShelfStatus',
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
title: '上架状态',
key: 'goodsSkuShelfStatus',
minWidth: 120,
sortable: true
},
{
title: '属性编号',
key: 'goodsCategoryAttributeAttrId',
minWidth: 120,
sortable: true
},
{
title: '属性排序',
key: 'goodsCategoryAttributeAttrOrder',
minWidth: 120,
sortable: true
},
{
title: '属性名称',
key: 'goodsAttributeAttrName',
minWidth: 120,
sortable: true
},
{
title: '属性代码',
key: 'goodsAttributeAttrCode',
minWidth: 120,
sortable: true
},
{
title: '数据类型',
key: 'goodsAttributeAttrType',
minWidth: 120,
sortable: true
},
{
title: '数据长度',
key: 'goodsAttributeAttrLength',
minWidth: 120,
sortable: true
},
{
title: '是否必填',
key: 'goodsAttributeAttrRequired',
minWidth: 120,
sortable: true
},
{
title: '是否前端显示',
key: 'goodsAttributeAttrDisplay',
minWidth: 120,
sortable: true
},
{
title: '属性值',
key: 'goodsAttributeValueAttrValue',
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
