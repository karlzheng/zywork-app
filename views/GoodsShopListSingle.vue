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
        <FormItem label="店铺编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始店铺编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束店铺编号" style="width: 100%;"/>
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
<FormItem label="类目编号"><Row>
	<i-col span="11">
	<FormItem prop="categoryIdMin">
	<InputNumber v-model="searchForm.categoryIdMin" placeholder="请输入开始类目编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="categoryIdMax">
	<InputNumber v-model="searchForm.categoryIdMax" placeholder="请输入结束类目编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="主体类型"><Row>
	<i-col span="11">
	<FormItem prop="subjectTypeMin">
	<InputNumber v-model="searchForm.subjectTypeMin" placeholder="请输入开始主体类型" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="subjectTypeMax">
	<InputNumber v-model="searchForm.subjectTypeMax" placeholder="请输入结束主体类型" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="店铺Logo" prop="logo">
	<Input v-model="searchForm.logo" placeholder="请输入店铺Logo"/>
</FormItem>
<FormItem label="店铺标题" prop="title">
	<Input v-model="searchForm.title" placeholder="请输入店铺标题"/>
</FormItem>
<FormItem label="店铺简介" prop="intro">
	<Input v-model="searchForm.intro" placeholder="请输入店铺简介"/>
</FormItem>
<FormItem label="店铺等级"><Row>
	<i-col span="11">
	<FormItem prop="levelMin">
	<InputNumber v-model="searchForm.levelMin" placeholder="请输入开始店铺等级" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="levelMax">
	<InputNumber v-model="searchForm.levelMax" placeholder="请输入结束店铺等级" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="审核状态"><Row>
	<i-col span="11">
	<FormItem prop="checkStatusMin">
	<InputNumber v-model="searchForm.checkStatusMin" placeholder="请输入开始审核状态" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="checkStatusMax">
	<InputNumber v-model="searchForm.checkStatusMax" placeholder="请输入结束审核状态" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="审核描述" prop="checkDescription">
	<Input v-model="searchForm.checkDescription" placeholder="请输入审核描述"/>
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
<FormItem label="审核时间"><Row>
	<i-col span="11">
	<FormItem prop="checkedTimeMin">
	<DatePicker @on-change="searchForm.checkedTimeMin=$event" :value="searchForm.checkedTimeMin" placeholder="请输入开始审核时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="checkedTimeMax">
	<DatePicker @on-change="searchForm.checkedTimeMax=$event" :value="searchForm.checkedTimeMax" placeholder="请输入结束审核时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
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
      <p>店铺编号: <span v-text="form.id"></span></p>
<p>用户编号: <span v-text="form.userId"></span></p>
<p>类目编号: <span v-text="form.categoryId"></span></p>
<p>主体类型: <span v-text="form.subjectType"></span></p>
<p>店铺Logo: <span v-text="form.logo"></span></p>
<p>店铺标题: <span v-text="form.title"></span></p>
<p>店铺简介: <span v-text="form.intro"></span></p>
<p>店铺等级: <span v-text="form.level"></span></p>
<p>审核状态: <span v-text="form.checkStatus"></span></p>
<p>审核描述: <span v-text="form.checkDescription"></span></p>
<p>审核人编号: <span v-text="form.checkedUserId"></span></p>
<p>审核时间: <span v-text="form.checkedTime"></span></p>
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
    name: 'GoodsShopListSingle',
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
          searchUrl: '/goods-shop/admin/pager-cond',
          allUrl: '/goods-shop/admin/all',
          detailUrl: '/goods-shop/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
userId: null,
categoryId: null,
subjectType: null,
logo: null,
title: null,
intro: null,
level: null,
checkStatus: null,
checkDescription: null,
checkedUserId: null,
checkedTime: null,
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
categoryId: null,
categoryIdMin: null, 
categoryIdMax: null, 
subjectType: null,
subjectTypeMin: null, 
subjectTypeMax: null, 
logo: null,
title: null,
intro: null,
level: null,
levelMin: null, 
levelMax: null, 
checkStatus: null,
checkStatusMin: null, 
checkStatusMax: null, 
checkDescription: null,
checkedUserId: null,
checkedUserIdMin: null, 
checkedUserIdMax: null, 
checkedTime: null,
checkedTimeMin: null, 
checkedTimeMax: null, 
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
title: '店铺编号',
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
title: '类目编号',
key: 'categoryId',
minWidth: 120,
sortable: true
},
{
title: '主体类型',
key: 'subjectType',
minWidth: 120,
sortable: true
},
{
title: '店铺Logo',
key: 'logo',
minWidth: 120,
sortable: true
},
{
title: '店铺标题',
key: 'title',
minWidth: 120,
sortable: true
},
{
title: '店铺简介',
key: 'intro',
minWidth: 120,
sortable: true
},
{
title: '店铺等级',
key: 'level',
minWidth: 120,
sortable: true
},
{
title: '审核状态',
key: 'checkStatus',
minWidth: 120,
sortable: true
},
{
title: '审核描述',
key: 'checkDescription',
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
title: '审核时间',
key: 'checkedTime',
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
		this.searchForm.pageNo = 1
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
