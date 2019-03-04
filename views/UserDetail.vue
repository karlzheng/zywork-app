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
        <FormItem label="昵称" prop="nickname">
	<Input v-model="form.nickname" placeholder="请输入昵称"/>
</FormItem>
<FormItem label="头像地址" prop="headicon">
	<Input v-model="form.headicon" placeholder="请输入头像地址"/>
</FormItem>
<FormItem label="性别" prop="gender">
	<InputNumber v-model="form.gender" placeholder="请输入性别" style="width: 100%;"/>
</FormItem>
<FormItem label="生日" prop="birthday">
	<DatePicker @on-change="form.birthday=$event" :value="form.birthday" placeholder="请输入生日" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="年龄" prop="age">
	<InputNumber v-model="form.age" placeholder="请输入年龄" style="width: 100%;"/>
</FormItem>
<FormItem label="QQ号" prop="qq">
	<Input v-model="form.qq" placeholder="请输入QQ号"/>
</FormItem>
<FormItem label="QQ二维码" prop="qqQrcode">
	<Input v-model="form.qqQrcode" placeholder="请输入QQ二维码"/>
</FormItem>
<FormItem label="微信号" prop="wechat">
	<Input v-model="form.wechat" placeholder="请输入微信号"/>
</FormItem>
<FormItem label="微信二维码" prop="wechatQrcode">
	<Input v-model="form.wechatQrcode" placeholder="请输入微信二维码"/>
</FormItem>
<FormItem label="支付宝账号" prop="alipay">
	<Input v-model="form.alipay" placeholder="请输入支付宝账号"/>
</FormItem>
<FormItem label="支付宝二维码" prop="alipayQrcode">
	<Input v-model="form.alipayQrcode" placeholder="请输入支付宝二维码"/>
</FormItem>
<FormItem label="分享码" prop="shareCode">
	<Input v-model="form.shareCode" placeholder="请输入分享码"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="昵称" prop="nickname">
	<Input v-model="form.nickname" placeholder="请输入昵称"/>
</FormItem>
<FormItem label="头像地址" prop="headicon">
	<Input v-model="form.headicon" placeholder="请输入头像地址"/>
</FormItem>
<FormItem label="性别" prop="gender">
	<InputNumber v-model="form.gender" placeholder="请输入性别" style="width: 100%;"/>
</FormItem>
<FormItem label="生日" prop="birthday">
	<DatePicker @on-change="form.birthday=$event" :value="form.birthday" placeholder="请输入生日" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
<FormItem label="年龄" prop="age">
	<InputNumber v-model="form.age" placeholder="请输入年龄" style="width: 100%;"/>
</FormItem>
<FormItem label="QQ号" prop="qq">
	<Input v-model="form.qq" placeholder="请输入QQ号"/>
</FormItem>
<FormItem label="QQ二维码" prop="qqQrcode">
	<Input v-model="form.qqQrcode" placeholder="请输入QQ二维码"/>
</FormItem>
<FormItem label="微信号" prop="wechat">
	<Input v-model="form.wechat" placeholder="请输入微信号"/>
</FormItem>
<FormItem label="微信二维码" prop="wechatQrcode">
	<Input v-model="form.wechatQrcode" placeholder="请输入微信二维码"/>
</FormItem>
<FormItem label="支付宝账号" prop="alipay">
	<Input v-model="form.alipay" placeholder="请输入支付宝账号"/>
</FormItem>
<FormItem label="支付宝二维码" prop="alipayQrcode">
	<Input v-model="form.alipayQrcode" placeholder="请输入支付宝二维码"/>
</FormItem>
<FormItem label="分享码" prop="shareCode">
	<Input v-model="form.shareCode" placeholder="请输入分享码"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
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
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">搜索</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
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
    name: 'UserDetail',
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
          addUrl: '/user-detail/admin/save',
          batchAddUrl: '/user-detail/admin/batch-save',
          editUrl: '/user-detail/admin/update',
          batchEditUrl: '/user-detail/admin/batch-update',
          searchUrl: '/user-detail/admin/pager-cond',
          allUrl: '/user-detail/admin/all',
          removeUrl: '/user-detail/admin/remove/',
          batchRemoveUrl: '/user-detail/admin/batch-remove',
          detailUrl: '/user-detail/admin/one/',
          activeUrl: '/user-detail/admin/active',
          batchActiveUrl: '/user-detail/admin/batch-active'
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
        validateRules: {
          nickname: [
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
headicon: [
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
qq: [
{type: 'string', min: 1, max: 20, message: '必须1-20个字符', trigger: 'blur'}
],
qqQrcode: [
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
wechat: [
{type: 'string', min: 1, max: 50, message: '必须1-50个字符', trigger: 'blur'}
],
wechatQrcode: [
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
alipay: [
{type: 'string', min: 1, max: 100, message: '必须1-100个字符', trigger: 'blur'}
],
alipayQrcode: [
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
shareCode: [
{type: 'string', min: 1, max: 36, message: '必须1-36个字符', trigger: 'blur'}
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
        this.searchForm.pageNo = 1
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
