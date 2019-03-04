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
        <FormItem label="钱包编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始钱包编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束钱包编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="支付密码" prop="payPassword">
	<Input v-model="searchForm.payPassword" placeholder="请输入支付密码"/>
</FormItem>
<FormItem label="人民币余额"><Row>
	<i-col span="11">
	<FormItem prop="rmbBalanceMin">
	<InputNumber v-model="searchForm.rmbBalanceMin" placeholder="请输入开始人民币余额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="rmbBalanceMax">
	<InputNumber v-model="searchForm.rmbBalanceMax" placeholder="请输入结束人民币余额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="可用余额"><Row>
	<i-col span="11">
	<FormItem prop="usableRmbBalanceMin">
	<InputNumber v-model="searchForm.usableRmbBalanceMin" placeholder="请输入开始可用余额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="usableRmbBalanceMax">
	<InputNumber v-model="searchForm.usableRmbBalanceMax" placeholder="请输入结束可用余额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="冻结余额"><Row>
	<i-col span="11">
	<FormItem prop="frozenRmbBalanceMin">
	<InputNumber v-model="searchForm.frozenRmbBalanceMin" placeholder="请输入开始冻结余额" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="frozenRmbBalanceMax">
	<InputNumber v-model="searchForm.frozenRmbBalanceMax" placeholder="请输入结束冻结余额" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="总积分"><Row>
	<i-col span="11">
	<FormItem prop="integralMin">
	<InputNumber v-model="searchForm.integralMin" placeholder="请输入开始总积分" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="integralMax">
	<InputNumber v-model="searchForm.integralMax" placeholder="请输入结束总积分" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="可用积分"><Row>
	<i-col span="11">
	<FormItem prop="usableIntegralMin">
	<InputNumber v-model="searchForm.usableIntegralMin" placeholder="请输入开始可用积分" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="usableIntegralMax">
	<InputNumber v-model="searchForm.usableIntegralMax" placeholder="请输入结束可用积分" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="冻结积分"><Row>
	<i-col span="11">
	<FormItem prop="frozenIntegralMin">
	<InputNumber v-model="searchForm.frozenIntegralMin" placeholder="请输入开始冻结积分" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="frozenIntegralMax">
	<InputNumber v-model="searchForm.frozenIntegralMax" placeholder="请输入结束冻结积分" style="width: 100%;"/>
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
        <Button type="primary" size="large" @click="searchOkModal('search')">确定</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>钱包编号: <span v-text="form.id"></span></p>
<p>支付密码: <span v-text="form.payPassword"></span></p>
<p>人民币余额: <span v-text="form.rmbBalance"></span></p>
<p>可用余额: <span v-text="form.usableRmbBalance"></span></p>
<p>冻结余额: <span v-text="form.frozenRmbBalance"></span></p>
<p>总积分: <span v-text="form.integral"></span></p>
<p>可用积分: <span v-text="form.usableIntegral"></span></p>
<p>冻结积分: <span v-text="form.frozenIntegral"></span></p>
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
    name: 'UserWalletList',
    data() {
      return {
        modal: {
          add: false,
          edit: false,
          search: false,
          detail: false
        },
        urls: {
          searchUrl: '/user-wallet/admin/pager-cond',
          allUrl: '/user-wallet/admin/all',
          detailUrl: '/user-wallet/admin/one/',
          multiUrl: '/user-wallet/admin/multi/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
payPassword: null,
rmbBalance: null,
usableRmbBalance: null,
frozenRmbBalance: null,
integral: null,
usableIntegral: null,
frozenIntegral: null,
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
payPassword: null,
rmbBalance: null,
rmbBalanceMin: null, 
rmbBalanceMax: null, 
usableRmbBalance: null,
usableRmbBalanceMin: null, 
usableRmbBalanceMax: null, 
frozenRmbBalance: null,
frozenRmbBalanceMin: null, 
frozenRmbBalanceMax: null, 
integral: null,
integralMin: null, 
integralMax: null, 
usableIntegral: null,
usableIntegralMin: null, 
usableIntegralMax: null, 
frozenIntegral: null,
frozenIntegralMin: null, 
frozenIntegralMax: null, 
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
title: '钱包编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '支付密码',
key: 'payPassword',
minWidth: 120,
sortable: true
},
{
title: '人民币余额',
key: 'rmbBalance',
minWidth: 120,
sortable: true
},
{
title: '可用余额',
key: 'usableRmbBalance',
minWidth: 120,
sortable: true
},
{
title: '冻结余额',
key: 'frozenRmbBalance',
minWidth: 120,
sortable: true
},
{
title: '总积分',
key: 'integral',
minWidth: 120,
sortable: true
},
{
title: '可用积分',
key: 'usableIntegral',
minWidth: 120,
sortable: true
},
{
title: '冻结积分',
key: 'frozenIntegral',
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
