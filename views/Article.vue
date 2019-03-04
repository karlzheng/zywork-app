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
        <FormItem label="类别编号" prop="categoryId">
	<InputNumber v-model="form.categoryId" placeholder="请输入类别编号" style="width: 100%;"/>
</FormItem>
<FormItem label="文章标题" prop="title">
	<Input v-model="form.title" placeholder="请输入文章标题"/>
</FormItem>
<FormItem label="封面图片" prop="coverImg">
	<Input v-model="form.coverImg" placeholder="请输入封面图片"/>
</FormItem>
<FormItem label="文章摘要" prop="summary">
	<Input v-model="form.summary" placeholder="请输入文章摘要"/>
</FormItem>
<FormItem label="文章内容" prop="content">
	<Input v-model="form.content" placeholder="请输入文章内容"/>
</FormItem>
<FormItem label="阅读量" prop="viewCount">
	<InputNumber v-model="form.viewCount" placeholder="请输入阅读量" style="width: 100%;"/>
</FormItem>
<FormItem label="创建人编号" prop="createId">
	<InputNumber v-model="form.createId" placeholder="请输入创建人编号" style="width: 100%;"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('addForm', 'add')">取消</Button>
        <Button type="primary" size="large" @click="add" :loading="loading.add">添加</Button>
      </div>
    </Modal>
    <Modal v-model="modal.edit" title="修改" @on-visible-change="changeModalVisibleResetForm('editForm', $event)">
      <Form ref="editForm" :model="form" :label-width="80" :rules="validateRules">
        <FormItem label="类别编号" prop="categoryId">
	<InputNumber v-model="form.categoryId" placeholder="请输入类别编号" style="width: 100%;"/>
</FormItem>
<FormItem label="文章标题" prop="title">
	<Input v-model="form.title" placeholder="请输入文章标题"/>
</FormItem>
<FormItem label="封面图片" prop="coverImg">
	<Input v-model="form.coverImg" placeholder="请输入封面图片"/>
</FormItem>
<FormItem label="文章摘要" prop="summary">
	<Input v-model="form.summary" placeholder="请输入文章摘要"/>
</FormItem>
<FormItem label="文章内容" prop="content">
	<Input v-model="form.content" placeholder="请输入文章内容"/>
</FormItem>
<FormItem label="阅读量" prop="viewCount">
	<InputNumber v-model="form.viewCount" placeholder="请输入阅读量" style="width: 100%;"/>
</FormItem>
<FormItem label="创建人编号" prop="createId">
	<InputNumber v-model="form.createId" placeholder="请输入创建人编号" style="width: 100%;"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetFormCancelModal('editForm', 'edit')">取消</Button>
        <Button type="primary" size="large" @click="edit" :loading="loading.edit">修改</Button>
      </div>
    </Modal>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="文章编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始文章编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束文章编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="类别编号"><Row>
	<i-col span="11">
	<FormItem prop="categoryIdMin">
	<InputNumber v-model="searchForm.categoryIdMin" placeholder="请输入开始类别编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="categoryIdMax">
	<InputNumber v-model="searchForm.categoryIdMax" placeholder="请输入结束类别编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="文章标题" prop="title">
	<Input v-model="searchForm.title" placeholder="请输入文章标题"/>
</FormItem>
<FormItem label="封面图片" prop="coverImg">
	<Input v-model="searchForm.coverImg" placeholder="请输入封面图片"/>
</FormItem>
<FormItem label="文章摘要" prop="summary">
	<Input v-model="searchForm.summary" placeholder="请输入文章摘要"/>
</FormItem>
<FormItem label="文章内容" prop="content">
	<Input v-model="searchForm.content" placeholder="请输入文章内容"/>
</FormItem>
<FormItem label="阅读量"><Row>
	<i-col span="11">
	<FormItem prop="viewCountMin">
	<InputNumber v-model="searchForm.viewCountMin" placeholder="请输入开始阅读量" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="viewCountMax">
	<InputNumber v-model="searchForm.viewCountMax" placeholder="请输入结束阅读量" style="width: 100%;"/>
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
<FormItem label="创建人编号"><Row>
	<i-col span="11">
	<FormItem prop="createIdMin">
	<InputNumber v-model="searchForm.createIdMin" placeholder="请输入开始创建人编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="createIdMax">
	<InputNumber v-model="searchForm.createIdMax" placeholder="请输入结束创建人编号" style="width: 100%;"/>
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
      <p>文章编号: <span v-text="form.id"></span></p>
<p>类别编号: <span v-text="form.categoryId"></span></p>
<p>文章标题: <span v-text="form.title"></span></p>
<p>封面图片: <span v-text="form.coverImg"></span></p>
<p>文章摘要: <span v-text="form.summary"></span></p>
<p>文章内容: <span v-text="form.content"></span></p>
<p>阅读量: <span v-text="form.viewCount"></span></p>
<p>版本号: <span v-text="form.version"></span></p>
<p>创建人编号: <span v-text="form.createId"></span></p>
<p>创建时间: <span v-text="form.createTime"></span></p>
<p>更新时间: <span v-text="form.updateTime"></span></p>
<p>是否激活: <span v-text="form.isActive"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'Article',
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
          addUrl: '/article/admin/save',
          batchAddUrl: '/article/admin/batch-save',
          editUrl: '/article/admin/update',
          batchEditUrl: '/article/admin/batch-update',
          searchUrl: '/article/admin/pager-cond',
          allUrl: '/article/admin/all',
          removeUrl: '/article/admin/remove/',
          batchRemoveUrl: '/article/admin/batch-remove',
          detailUrl: '/article/admin/one/',
          activeUrl: '/article/admin/active',
          batchActiveUrl: '/article/admin/batch-active'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
categoryId: null,
title: null,
coverImg: null,
summary: null,
content: null,
viewCount: null,
version: null,
createId: null,
createTime: null,
updateTime: null,
isActive: null,

        },
        validateRules: {
          categoryId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
],
title: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 50, message: '必须1-50个字符', trigger: 'blur'}
],
coverImg: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 500, message: '必须1-500个字符', trigger: 'blur'}
],
summary: [
{type: 'string', min: 1, max: 255, message: '必须1-255个字符', trigger: 'blur'}
],
content: [
{type: 'string', required: true, message: '此项为必须项', trigger: 'blur'},
{type: 'string', min: 1, max: 65535, message: '必须1-65535个字符', trigger: 'blur'}
],
createId: [
{type: 'integer', required: true, message: '此项为必须项', trigger: 'blur, change'}
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
categoryId: null,
categoryIdMin: null, 
categoryIdMax: null, 
title: null,
coverImg: null,
summary: null,
content: null,
viewCount: null,
viewCountMin: null, 
viewCountMax: null, 
version: null,
versionMin: null, 
versionMax: null, 
createId: null,
createIdMin: null, 
createIdMax: null, 
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
title: '文章编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '类别编号',
key: 'categoryId',
minWidth: 120,
sortable: true
},
{
title: '文章标题',
key: 'title',
minWidth: 120,
sortable: true
},
{
title: '封面图片',
key: 'coverImg',
minWidth: 120,
sortable: true
},
{
title: '文章摘要',
key: 'summary',
minWidth: 120,
sortable: true
},
{
title: '文章内容',
key: 'content',
minWidth: 120,
sortable: true
},
{
title: '阅读量',
key: 'viewCount',
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
title: '创建人编号',
key: 'createId',
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
