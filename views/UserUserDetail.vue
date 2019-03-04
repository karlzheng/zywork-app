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
	<InputNumber v-model="searchForm.userIdMin" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userIdMax">
	<InputNumber v-model="searchForm.userIdMax" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="手机号" prop="userPhone">
	<Input v-model="searchForm.userPhone"/>
</FormItem>
<FormItem label="用户邮箱" prop="userEmail">
	<Input v-model="searchForm.userEmail"/>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="userCreateTimeMin">
	<DatePicker @on-change="searchForm.userCreateTimeMin=$event" :value="searchForm.userCreateTimeMin" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userCreateTimeMax">
	<DatePicker @on-change="searchForm.userCreateTimeMax=$event" :value="searchForm.userCreateTimeMax" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="昵称" prop="userDetailNickname">
	<Input v-model="searchForm.userDetailNickname"/>
</FormItem>
<FormItem label="头像地址" prop="userDetailHeadicon">
	<Input v-model="searchForm.userDetailHeadicon"/>
</FormItem>
<FormItem label="性别"><Row>
	<i-col span="11">
	<FormItem prop="userDetailGenderMin">
	<InputNumber v-model="searchForm.userDetailGenderMin" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userDetailGenderMax">
	<InputNumber v-model="searchForm.userDetailGenderMax" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="生日"><Row>
	<i-col span="11">
	<FormItem prop="userDetailBirthdayMin">
	<DatePicker @on-change="searchForm.userDetailBirthdayMin=$event" :value="searchForm.userDetailBirthdayMin" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userDetailBirthdayMax">
	<DatePicker @on-change="searchForm.userDetailBirthdayMax=$event" :value="searchForm.userDetailBirthdayMax" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="年龄"><Row>
	<i-col span="11">
	<FormItem prop="userDetailAgeMin">
	<InputNumber v-model="searchForm.userDetailAgeMin" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userDetailAgeMax">
	<InputNumber v-model="searchForm.userDetailAgeMax" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="QQ号" prop="userDetailQq">
	<Input v-model="searchForm.userDetailQq"/>
</FormItem>
<FormItem label="QQ二维码" prop="userDetailQqQrcode">
	<Input v-model="searchForm.userDetailQqQrcode"/>
</FormItem>
<FormItem label="微信号" prop="userDetailWechat">
	<Input v-model="searchForm.userDetailWechat"/>
</FormItem>
<FormItem label="微信二维码" prop="userDetailWechatQrcode">
	<Input v-model="searchForm.userDetailWechatQrcode"/>
</FormItem>
<FormItem label="支付宝账号" prop="userDetailAlipay">
	<Input v-model="searchForm.userDetailAlipay"/>
</FormItem>
<FormItem label="支付宝二维码" prop="userDetailAlipayQrcode">
	<Input v-model="searchForm.userDetailAlipayQrcode"/>
</FormItem>
<FormItem label="分享码" prop="userDetailShareCode">
	<Input v-model="searchForm.userDetailShareCode"/>
</FormItem>
<FormItem label="版本号"><Row>
	<i-col span="11">
	<FormItem prop="userDetailVersionMin">
	<InputNumber v-model="searchForm.userDetailVersionMin" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="userDetailVersionMax">
	<InputNumber v-model="searchForm.userDetailVersionMax" style="width: 100%;"/>
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
<p>创建时间: <span v-text="form.userCreateTime"></span></p>
<p>昵称: <span v-text="form.userDetailNickname"></span></p>
<p>头像地址: <span v-text="form.userDetailHeadicon"></span></p>
<p>性别: <span v-text="form.userDetailGender"></span></p>
<p>生日: <span v-text="form.userDetailBirthday"></span></p>
<p>年龄: <span v-text="form.userDetailAge"></span></p>
<p>QQ号: <span v-text="form.userDetailQq"></span></p>
<p>QQ二维码: <span v-text="form.userDetailQqQrcode"></span></p>
<p>微信号: <span v-text="form.userDetailWechat"></span></p>
<p>微信二维码: <span v-text="form.userDetailWechatQrcode"></span></p>
<p>支付宝账号: <span v-text="form.userDetailAlipay"></span></p>
<p>支付宝二维码: <span v-text="form.userDetailAlipayQrcode"></span></p>
<p>分享码: <span v-text="form.userDetailShareCode"></span></p>
<p>版本号: <span v-text="form.userDetailVersion"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'UserUserDetail',
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
          searchUrl: '/user-userdetail/admin/pager-cond',
          allUrl: '/user-userdetail/admin/all',
          detailUrl: '/user-userdetail/admin/one/',
          multiUrl: '/user-userdetail/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          userId: null,
userPhone: null,
userEmail: null,
userCreateTime: null,
userDetailNickname: null,
userDetailHeadicon: null,
userDetailGender: null,
userDetailBirthday: null,
userDetailAge: null,
userDetailQq: null,
userDetailQqQrcode: null,
userDetailWechat: null,
userDetailWechatQrcode: null,
userDetailAlipay: null,
userDetailAlipayQrcode: null,
userDetailShareCode: null,
userDetailVersion: null,

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
userCreateTime: null,
userCreateTimeMin: null, 
userCreateTimeMax: null, 
userDetailNickname: null,
userDetailHeadicon: null,
userDetailGender: null,
userDetailGenderMin: null, 
userDetailGenderMax: null, 
userDetailBirthday: null,
userDetailBirthdayMin: null, 
userDetailBirthdayMax: null, 
userDetailAge: null,
userDetailAgeMin: null, 
userDetailAgeMax: null, 
userDetailQq: null,
userDetailQqQrcode: null,
userDetailWechat: null,
userDetailWechatQrcode: null,
userDetailAlipay: null,
userDetailAlipayQrcode: null,
userDetailShareCode: null,
userDetailVersion: null,
userDetailVersionMin: null, 
userDetailVersionMax: null, 

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
title: '创建时间',
key: 'userCreateTime',
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
title: '性别',
key: 'userDetailGender',
minWidth: 120,
sortable: true
},
{
title: '生日',
key: 'userDetailBirthday',
minWidth: 120,
sortable: true
},
{
title: '年龄',
key: 'userDetailAge',
minWidth: 120,
sortable: true
},
{
title: 'QQ号',
key: 'userDetailQq',
minWidth: 120,
sortable: true
},
{
title: 'QQ二维码',
key: 'userDetailQqQrcode',
minWidth: 120,
sortable: true
},
{
title: '微信号',
key: 'userDetailWechat',
minWidth: 120,
sortable: true
},
{
title: '微信二维码',
key: 'userDetailWechatQrcode',
minWidth: 120,
sortable: true
},
{
title: '支付宝账号',
key: 'userDetailAlipay',
minWidth: 120,
sortable: true
},
{
title: '支付宝二维码',
key: 'userDetailAlipayQrcode',
minWidth: 120,
sortable: true
},
{
title: '分享码',
key: 'userDetailShareCode',
minWidth: 120,
sortable: true
},
{
title: '版本号',
key: 'userDetailVersion',
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
