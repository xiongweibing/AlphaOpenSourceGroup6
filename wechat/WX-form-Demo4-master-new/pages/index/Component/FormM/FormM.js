// pages/index/Component/FormM/FormM.js

const app = getApp()
Page({
  //初始化数据
  data: {
    array: ['渝北区', '渝中区', '九龙坡', '沙坪坝','江北','南岸'],
    index1: 0,
    index2: 0,
    lastMonthIncameValue:'',
    lastMonthUserValue: ''
  },
  //表单提交按钮
  formSubmit: function(e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    if (e.detail.value.input1.length == 0 || e.detail.value.input2.length == 0 ) {
      wx.showToast({
        title: '输入不能为空!',
        icon: 'loading',
        duration: 2000
      });
    } else {
      this.setData({
        lastMonthIncameValue: e.detail.value.input1,
        lastMonthUserValue: e.detail.value.input2
      })
      this.bindtest(e)
    }
  },
  //表单重置按钮
  formReset: function(e) {
    console.log('form发生了reset事件，携带数据为：', e.detail.value)
    this.setData({
      allValue:''
    })
  },
  formReport: function (e) {
    console.log('form发生了report事件，携带数据为：', e.detail.value)
    this.setData({
      allValue: ''
    })
  },
  //---------------------与选择器相关的方法
  //地区选择
  bindPickerChange: function(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index1: e.detail.value
    })
  },
 
  //日期选择
  bindDateChange: function(e) {
    this.setData({
      date: e.detail.value
    })
  },
  //时间选择
  bindTimeChange: function(e) {
    this.setData({
      time: e.detail.value
    })
  },
  
  bindtest: function (e) {

    wx.request({
      url: 'http://2t177168l5.iask.in:28349/MyTelecomWeb/MobileTest',
      data: {
        areaName: e.detail.value.areaPicker,
        radioPicker: e.detail.value.radiogroup,
        month: e.detail.value.slider,
        incame: e.detail.value.input1,
        userNum: e.detail.value.input2
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        wx.showToast({
          title: '数据提交成功!',
          icon: 'sucess',
          duration: 2000
        });
      },
      fail: function (res) {
        console.log(".....fail.....");
        wx.showToast({
          title: '提交失败,请稍后再试',
          icon: 'success',
          duration: 2000
        });
      }
    })
  },

  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    // 页面显示
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  }
})