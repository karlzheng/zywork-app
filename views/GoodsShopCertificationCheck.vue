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
        <FormItem label="店铺编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsShopIdMin">
	<InputNumber v-model="searchForm.goodsShopIdMin" placeholder="请输入开始店铺编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsShopIdMax">
	<InputNumber v-model="searchForm.goodsShopIdMax" placeholder="请输入结束店铺编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="类目编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsShopCategoryIdMin">
	<InputNumber v-model="searchForm.goodsShopCategoryIdMin" placeholder="请输入开始类目编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsShopCategoryIdMax">
	<InputNumber v-model="searchForm.goodsShopCategoryIdMax" placeholder="请输入结束类目编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="主体类型"><Row>
	<i-col span="11">
	<FormItem prop="goodsShopSubjectTypeMin">
	<InputNumber v-model="searchForm.goodsShopSubjectTypeMin" placeholder="请输入开始主体类型" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsShopSubjectTypeMax">
	<InputNumber v-model="searchForm.goodsShopSubjectTypeMax" placeholder="请输入结束主体类型" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="店铺Logo" prop="goodsShopLogo">
	<Input v-model="searchForm.goodsShopLogo" placeholder="请输入店铺Logo"/>
</FormItem>
<FormItem label="店铺标题" prop="goodsShopTitle">
	<Input v-model="searchForm.goodsShopTitle" placeholder="请输入店铺标题"/>
</FormItem>
<FormItem label="店铺审核编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsShopCheckIdMin">
	<InputNumber v-model="searchForm.goodsShopCheckIdMin" placeholder="请输入开始店铺审核编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsShopCheckIdMax">
	<InputNumber v-model="searchForm.goodsShopCheckIdMax" placeholder="请输入结束店铺审核编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="审核状态"><Row>
	<i-col span="11">
	<FormItem prop="goodsShopCheckCheckStatusMin">
	<InputNumber v-model="searchForm.goodsShopCheckCheckStatusMin" placeholder="请输入开始审核状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsShopCheckCheckStatusMax">
	<InputNumber v-model="searchForm.goodsShopCheckCheckStatusMax" placeholder="请输入结束审核状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="审核描述" prop="goodsShopCheckCheckDescription">
	<Input v-model="searchForm.goodsShopCheckCheckDescription" placeholder="请输入审核描述"/>
</FormItem>
<FormItem label="审核人编号"><Row>
	<i-col span="11">
	<FormItem prop="goodsShopCheckCheckedUserIdMin">
	<InputNumber v-model="searchForm.goodsShopCheckCheckedUserIdMin" placeholder="请输入开始审核人编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsShopCheckCheckedUserIdMax">
	<InputNumber v-model="searchForm.goodsShopCheckCheckedUserIdMax" placeholder="请输入结束审核人编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="goodsShopCheckCreateTimeMin">
	<DatePicker @on-change="searchForm.goodsShopCheckCreateTimeMin=$event" :value="searchForm.goodsShopCheckCreateTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="goodsShopCheckCreateTimeMax">
	<DatePicker @on-change="searchForm.goodsShopCheckCreateTimeMax=$event" :value="searchForm.goodsShopCheckCreateTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="认证详情JSON" prop="goodsShopCertificationDetail">
	<Input v-model="searchForm.goodsShopCertificationDetail" placeholder="请输入认证详情JSON"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>店铺编号: <span v-text="form.goodsShopId"></span></p>
<p>类目编号: <span v-text="form.goodsShopCategoryId"></span></p>
<p>主体类型: <span v-text="form.goodsShopSubjectType"></span></p>
<p>店铺Logo: <span v-text="form.goodsShopLogo"></span></p>
<p>店铺标题: <span v-text="form.goodsShopTitle"></span></p>
<p>店铺审核编号: <span v-text="form.goodsShopCheckId"></span></p>
<p>审核状态: <span v-text="form.goodsShopCheckCheckStatus"></span></p>
<p>审核描述: <span v-text="form.goodsShopCheckCheckDescription"></span></p>
<p>审核人编号: <span v-text="form.goodsShopCheckCheckedUserId"></span></p>
<p>创建时间: <span v-text="form.goodsShopCheckCreateTime"></span></p>
<p>认证详情JSON: <span v-text="form.goodsShopCertificationDetail"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'GoodsShopCertificationCheck',
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
          searchUrl: '/shop-certification-check/admin/pager-cond',
          allUrl: '/shop-certification-check/admin/all',
          detailUrl: '/shop-certification-check/admin/one/',
          multiUrl: '/shop-certification-check/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          goodsShopId: null,
goodsShopCategoryId: null,
goodsShopSubjectType: null,
goodsShopLogo: null,
goodsShopTitle: null,
goodsShopCheckId: null,
goodsShopCheckCheckStatus: null,
goodsShopCheckCheckDescription: null,
goodsShopCheckCheckedUserId: null,
goodsShopCheckCreateTime: null,
goodsShopCertificationDetail: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          goodsShopId: null,
goodsShopIdMin: null, 
goodsShopIdMax: null, 
goodsShopCategoryId: null,
goodsShopCategoryIdMin: null, 
goodsShopCategoryIdMax: null, 
goodsShopSubjectType: null,
goodsShopSubjectTypeMin: null, 
goodsShopSubjectTypeMax: null, 
goodsShopLogo: null,
goodsShopTitle: null,
goodsShopCheckId: null,
goodsShopCheckIdMin: null, 
goodsShopCheckIdMax: null, 
goodsShopCheckCheckStatus: null,
goodsShopCheckCheckStatusMin: null, 
goodsShopCheckCheckStatusMax: null, 
goodsShopCheckCheckDescription: null,
goodsShopCheckCheckedUserId: null,
goodsShopCheckCheckedUserIdMin: null, 
goodsShopCheckCheckedUserIdMax: null, 
goodsShopCheckCreateTime: null,
goodsShopCheckCreateTimeMin: null, 
goodsShopCheckCreateTimeMax: null, 
goodsShopCertificationDetail: null,

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
title: '店铺编号',
key: 'goodsShopId',
minWidth: 120,
sortable: true
},
{
title: '类目编号',
key: 'goodsShopCategoryId',
minWidth: 120,
sortable: true
},
{
title: '主体类型',
key: 'goodsShopSubjectType',
minWidth: 120,
sortable: true
},
{
title: '店铺Logo',
key: 'goodsShopLogo',
minWidth: 120,
sortable: true
},
{
title: '店铺标题',
key: 'goodsShopTitle',
minWidth: 120,
sortable: true
},
{
title: '店铺审核编号',
key: 'goodsShopCheckId',
minWidth: 120,
sortable: true
},
{
title: '审核状态',
key: 'goodsShopCheckCheckStatus',
minWidth: 120,
sortable: true
},
{
title: '审核描述',
key: 'goodsShopCheckCheckDescription',
minWidth: 120,
sortable: true
},
{
title: '审核人编号',
key: 'goodsShopCheckCheckedUserId',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'goodsShopCheckCreateTime',
minWidth: 120,
sortable: true
},
{
title: '认证详情JSON',
key: 'goodsShopCertificationDetail',
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
