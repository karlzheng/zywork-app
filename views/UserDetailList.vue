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
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束用户编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="昵称" prop="nickname">
	<Input v-model="searchForm.nickname" placeholder="请输入昵称"/>
</FormItem>
<FormItem label="头像地址" prop="headicon">
	<Input v-model="searchForm.headicon" placeholder="请输入头像地址"/>
</FormItem>
<FormItem label="性别"><Row>
	<i-col span="11">
	<FormItem prop="genderMin">
	<InputNumber v-model="searchForm.genderMin" placeholder="请输入开始性别" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="genderMax">
	<InputNumber v-model="searchForm.genderMax" placeholder="请输入结束性别" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="生日"><Row>
	<i-col span="11">
	<FormItem prop="birthdayMin">
	<DatePicker @on-change="searchForm.birthdayMin=$event" :value="searchForm.birthdayMin" placeholder="请输入开始生日" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="birthdayMax">
	<DatePicker @on-change="searchForm.birthdayMax=$event" :value="searchForm.birthdayMax" placeholder="请输入结束生日" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="年龄"><Row>
	<i-col span="11">
	<FormItem prop="ageMin">
	<InputNumber v-model="searchForm.ageMin" placeholder="请输入开始年龄" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="ageMax">
	<InputNumber v-model="searchForm.ageMax" placeholder="请输入结束年龄" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="QQ号" prop="qq">
	<Input v-model="searchForm.qq" placeholder="请输入QQ号"/>
</FormItem>
<FormItem label="QQ二维码" prop="qqQrcode">
	<Input v-model="searchForm.qqQrcode" placeholder="请输入QQ二维码"/>
</FormItem>
<FormItem label="微信号" prop="wechat">
	<Input v-model="searchForm.wechat" placeholder="请输入微信号"/>
</FormItem>
<FormItem label="微信二维码" prop="wechatQrcode">
	<Input v-model="searchForm.wechatQrcode" placeholder="请输入微信二维码"/>
</FormItem>
<FormItem label="支付宝账号" prop="alipay">
	<Input v-model="searchForm.alipay" placeholder="请输入支付宝账号"/>
</FormItem>
<FormItem label="支付宝二维码" prop="alipayQrcode">
	<Input v-model="searchForm.alipayQrcode" placeholder="请输入支付宝二维码"/>
</FormItem>
<FormItem label="分享码" prop="shareCode">
	<Input v-model="searchForm.shareCode" placeholder="请输入分享码"/>
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
        <Button type="primary" size="large" @click="searchOkModal('search')">确定</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>用户编号: <span v-text="form.id"></span></p>
<p>昵称: <span v-text="form.nickname"></span></p>
<p>头像地址: <span v-text="form.headicon"></span></p>
<p>性别: <span v-text="form.gender"></span></p>
<p>生日: <span v-text="form.birthday"></span></p>
<p>年龄: <span v-text="form.age"></span></p>
<p>QQ号: <span v-text="form.qq"></span></p>
<p>QQ二维码: <span v-text="form.qqQrcode"></span></p>
<p>微信号: <span v-text="form.wechat"></span></p>
<p>微信二维码: <span v-text="form.wechatQrcode"></span></p>
<p>支付宝账号: <span v-text="form.alipay"></span></p>
<p>支付宝二维码: <span v-text="form.alipayQrcode"></span></p>
<p>分享码: <span v-text="form.shareCode"></span></p>
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
    name: 'UserDetailList',
    data() {
      return {
        modal: {
          add: false,
          edit: false,
          search: false,
          detail: false
        },
        urls: {
          searchUrl: '/user-detail/admin/pager-cond',
          allUrl: '/user-detail/admin/all',
          detailUrl: '/user-detail/admin/one/',
          multiUrl: '/user-detail/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
nickname: null,
headicon: null,
gender: null,
birthday: null,
age: null,
qq: null,
qqQrcode: null,
wechat: null,
wechatQrcode: null,
alipay: null,
alipayQrcode: null,
shareCode: null,
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
nickname: null,
headicon: null,
gender: null,
genderMin: null, 
genderMax: null, 
birthday: null,
birthdayMin: null, 
birthdayMax: null, 
age: null,
ageMin: null, 
ageMax: null, 
qq: null,
qqQrcode: null,
wechat: null,
wechatQrcode: null,
alipay: null,
alipayQrcode: null,
shareCode: null,
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
title: '用户编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '昵称',
key: 'nickname',
minWidth: 120,
sortable: true
},
{
title: '头像地址',
key: 'headicon',
minWidth: 120,
sortable: true
},
{
title: '性别',
key: 'gender',
minWidth: 120,
sortable: true
},
{
title: '生日',
key: 'birthday',
minWidth: 120,
sortable: true
},
{
title: '年龄',
key: 'age',
minWidth: 120,
sortable: true
},
{
title: 'QQ号',
key: 'qq',
minWidth: 120,
sortable: true
},
{
title: 'QQ二维码',
key: 'qqQrcode',
minWidth: 120,
sortable: true
},
{
title: '微信号',
key: 'wechat',
minWidth: 120,
sortable: true
},
{
title: '微信二维码',
key: 'wechatQrcode',
minWidth: 120,
sortable: true
},
{
title: '支付宝账号',
key: 'alipay',
minWidth: 120,
sortable: true
},
{
title: '支付宝二维码',
key: 'alipayQrcode',
minWidth: 120,
sortable: true
},
{
title: '分享码',
key: 'shareCode',
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
      },
      confirmSelection() {
        // 确认选择的逻辑
      }
    }
  }
</script>

<style>
</style>
