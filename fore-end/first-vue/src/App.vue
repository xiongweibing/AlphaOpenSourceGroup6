<template>
  <div id="app">
    <div class="table-container1">
        <table id="table1" border="1">
          <caption>异网渠道/个</caption>
        <tr>
          <th>移动</th>
          <th>联通</th>
        </tr>
        <tr>
          <td id="ywqd1"></td>
          <td id="ywqd2"></td>
        </tr>
      </table>
    </div>
    
        <div class="table-container2">
        <table id="table2" border="1">
          <caption>存量用户/万</caption>
        <tr>
          <th>移动用户数</th>
          <th>宽带用户数</th>
          <th>IPTV用户数</th>
        </tr>
        <tr>
          <td id="clyh1">99</td>
          <td id="clyh2">99</td>
          <td id="clyh3">99</td>
        </tr>
      </table>
    </div>

        <div class="table-container3">
        <table id="table3" border="1">
          <caption>本网渠道/个</caption>
        <tr>
          <th>专营店</th>
          <th>区包店</th>
          <th>开放门店</th>
          <th>直销代理</th>
          <th>合计</th>
        </tr>
        <tr>
          <td  id="bwqd1"></td>
          <td  id="bwqd2"></td>
          <td  id="bwqd3"></td>
          <td  id="bwqd4"></td>
          <td  id="bwqd5"></td>
        </tr>
      </table>
    </div>

        <div class="table-container4">
        <table id="table4" border="1">
          <caption>全市概况/万</caption>
        <tr>
          <th>片区</th>
          <th>住户数</th>
          <th>人口数</th>
          <th>光缆口数</th>
          <th>宽带数</th>
          <th>IPTV数</th>
          <th>异网宽带数</th>
        </tr>
        <tr>
          <th>渝中区</th>
          <th id="qsgk11">200</th>
          <th id="qsgk12">200</th>
          <th id="qsgk13">200</th>
          <th id="qsgk14">200</th>
          <th id="qsgk15">200</th>
          <th id="qsgk16">200</th>
        </tr>
        <tr>
          <th>渝北区</th>
          <th id="qsgk21">200</th>
          <th id="qsgk22">200</th>
          <th id="qsgk23">200</th>
          <th id="qsgk24">200</th>
          <th id="qsgk25">200</th>
          <th id="qsgk26">200</th>
        </tr>
        <tr>
          <th>南岸区</th>
          <th id="qsgk31">200</th>
          <th id="qsgk32">200</th>
          <th id="qsgk33">200</th>
          <th id="qsgk34">200</th>
          <th id="qsgk35">200</th>
          <th id="qsgk36">200</th>
        </tr>
        <tr>
          <th>江北区</th>
          <th id="qsgk41">200</th>
          <th id="qsgk42">200</th>
          <th id="qsgk43">200</th>
          <th id="qsgk44">200</th>
          <th id="qsgk45">200</th>
          <th id="qsgk46">200</th>
        </tr>
        <tr>
          <th>沙坪坝区</th>
          <th id="qsgk51">200</th>
          <th id="qsgk52">200</th>
          <th id="qsgk53">200</th>
          <th id="qsgk54">200</th>
          <th id="qsgk55">200</th>
          <th id="qsgk56">200</th>
        </tr>
        <tr>
          <th>九龙坡区</th>
          <th id="qsgk61">200</th>
          <th id="qsgk62">200</th>
          <th id="qsgk63">200</th>
          <th id="qsgk64">200</th>
          <th id="qsgk65">200</th>
          <th id="qsgk66">200</th>
        </tr>
      </table>
    </div>

    <mt-button type="default">移网</mt-button>
    <mt-button type="primary">固网</mt-button>
    <mt-button type="danger">IPTV</mt-button>

    <!-- <div id = "test">
    <div class="test">hello world</div>
    </div> -->

    <!-- <div id="nav"> -->
    <div id="sichuan"></div>

    <div id = analysis>
    <!-- <div id="bar-graph"></div> -->
    <div id="fold-line"></div>
    <div id="pie-chart"></div>
    </div>

  </div>


</template>

<script>
const echarts = require("echarts");
import "whatwg-fetch";
export default {
  name: "echarts",
  props: ["userJson"],
  data() {
    return {
      chart: null,
      arr: [
        [{"id":1, "area":"Yubei", "tenement_num":334, "population":767, "FBI_num":511, "broadband_num":224, "IPTV_num":205, "otherIPTV_num":229}, {"id":2, "area":"Yuzhong", "tenement_num":145, "population":298, "FBI_num":266, "broadband_num":129, "IPTV_num":87, "otherIPTV_num":101}, {"id":3, "area":"Nanan", "tenement_num":214, "population":523, "FBI_num":340, "broadband_num":177, "IPTV_num":116, "otherIPTV_num":152}, {"id":4, "area":"Jiangbei", "tenement_num":223, "population":517, "FBI_num":407, "broadband_num":201, "IPTV_num":134, "otherIPTV_num":178}, {"id":5, "area":"Jiulongpo", "tenement_num":217, "population":477, "FBI_num":480, "broadband_num":176, "IPTV_num":157, "otherIPTV_num":211}, {"id":6, "area":"Shapingba", "tenement_num":267, "population":489, "FBI_num":501, "broadband_num":231, "IPTV_num":191, "otherIPTV_num":246}],

        [{"id":1, "channel_type":"monopolized store", "channel_num":2812}, {"id":2, "channel_type":"area contract", "channel_num":1082}, {"id":3, "channel_type":"open store", "channel_num":2467}, {"id":4, "channel_type":"direct agent", "channel_num":1095}, {"id":5, "channel_type":"sum", "channel_num":7456}],

        [{"id":1, "carrieroperator":"CMCC", "channel_num":9233}, {"id":2, "carrieroperator":"CUCC", "channel_num":5712}],

        [{"id":1, "service_type":"mobile", "user_num":843}, {"id":2, "service_type":"broadband", "user_num":675}, {"id":3, "service_type":"IPTV", "user_num":369}],

        [{"id":1, "area":"jiangbei", "carrieroperator":"CT", "M_income":76454.6, "M_userPer":154.0, "Month_1":345.6, "Month_2":368.4, "Month_3":298.5, "Month_4":281.7, "Month_5":312.6, "Month_6":391.6, "Month_7":300.6, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":2, "area":"jiangbei", "carrieroperator":"CMCC", "M_income":160750.7, "M_userPer":302.0, "Month_1":698.1, "Month_2":712.5, "Month_3":709.2, "Month_4":645.2, "Month_5":721.2, "Month_6":621.1, "Month_7":680.4, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":3, "area":"jiangbei", "carrieroperator":"CUCC", "M_income":49662.8, "M_userPer":127.0, "Month_1":213.9, "Month_2":245.8, "Month_3":209.6, "Month_4":178.5, "Month_5":199.4, "Month_6":278.4, "Month_7":271.1, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":4, "area":"jiulongpo", "carrieroperator":"CT", "M_income":82335.7, "M_userPer":156.0, "Month_1":298.4, "Month_2":301.3, "Month_3":224.6, "Month_4":260.1, "Month_5":334.7, "Month_6":247.4, "Month_7":219.5, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":5, "area":"jiulongpo", "carrieroperator":"CMCC", "M_income":143107.3, "M_userPer":300.0, "Month_1":708.1, "Month_2":677.1, "Month_3":635.5, "Month_4":597.2, "Month_5":691.4, "Month_6":603.3, "Month_7":578.1, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":6, "area":"jiulongpo", "carrieroperator":"CUCC", "M_income":56850.8, "M_userPer":140.0, "Month_1":187.4, "Month_2":201.5, "Month_3":265.2, "Month_4":234.8, "Month_5":276.6, "Month_6":197.4, "Month_7":323.6, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":7, "area":"nanan", "carrieroperator":"CT", "M_income":95078.1, "M_userPer":150.0, "Month_1":251.5, "Month_2":268.9, "Month_3":267.2, "Month_4":271.6, "Month_5":256.7, "Month_6":267.5, "Month_7":331.2, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":8, "area":"nanan", "carrieroperator":"CMCC", "M_income":166631.8, "M_userPer":327.0, "Month_1":567.5, "Month_2":607.6, "Month_3":588.8, "Month_4":571.0, "Month_5":610.2, "Month_6":634.1, "Month_7":602.2, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":9, "area":"nanan", "carrieroperator":"CUCC", "M_income":60118.1, "M_userPer":130.0, "Month_1":234.7, "Month_2":213.6, "Month_3":246.1, "Month_4":198.1, "Month_5":298.3, "Month_6":210.4, "Month_7":200.4, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":10, "area":"yuzhong", "carrieroperator":"CT", "M_income":90177.2, "M_userPer":150.0, "Month_1":201.3, "Month_2":215.2, "Month_3":231.3, "Month_4":229.5, "Month_5":251.2, "Month_6":255.8, "Month_7":269.1, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":11, "area":"yuzhong", "carrieroperator":"CMCC", "M_income":190156.3, "M_userPer":300.0, "Month_1":578.3, "Month_2":587.2, "Month_3":598.3, "Month_4":571.9, "Month_5":588.2, "Month_6":601.2, "Month_7":611.3, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":12, "area":"yuzhong", "carrieroperator":"CUCC", "M_income":62732.0, "M_userPer":160.0, "Month_1":231.1, "Month_2":224.1, "Month_3":219.1, "Month_4":268.5, "Month_5":234.6, "Month_6":246.7, "Month_7":199.2, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":13, "area":"yubei", "carrieroperator":"CT", "M_income":98018.7, "M_userPer":150.0, "Month_1":376.1, "Month_2":360.5, "Month_3":378.1, "Month_4":381.4, "Month_5":367.4, "Month_6":376.1, "Month_7":378.3, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":14, "area":"yubei", "carrieroperator":"CMCC", "M_income":196037.4, "M_userPer":296.0, "Month_1":701.3, "Month_2":689.1, "Month_3":657.3, "Month_4":708.1, "Month_5":688.2, "Month_6":697.3, "Month_7":711.4, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":15, "area":"yubei", "carrieroperator":"CUCC", "M_income":65345.8, "M_userPer":140.0, "Month_1":276.3, "Month_2":257.1, "Month_3":289.1, "Month_4":219.9, "Month_5":244.2, "Month_6":256.5, "Month_7":231.5, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":16, "area":"shangpingba", "carrieroperator":"CT", "M_income":29405.6, "M_userPer":170.0, "Month_1":278.1, "Month_2":265.1, "Month_3":275.1, "Month_4":274.6, "Month_5":282.1, "Month_6":262.4, "Month_7":297.3, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":17, "area":"shangpingba", "carrieroperator":"CMCC", "M_income":98018.7, "M_userPer":300.0, "Month_1":564.1, "Month_2":578.2, "Month_3":598.1, "Month_4":613.3, "Month_5":607.1, "Month_6":587.3, "Month_7":598.2, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}, {"id":18, "area":"shangpingba", "carrieroperator":"CUCC", "M_income":26138.3, "M_userPer":140.0, "Month_1":234.4, "Month_2":251.2, "Month_3":214.1, "Month_4":210.0, "Month_5":246.7, "Month_6":197.6, "Month_7":229.9, "Month_8":0.0, "Month_9":0.0, "Month_10":0.0, "Month_11":0.0, "Month_12":0.0}]
        ],
      isFirst: true
    };
  },

  mounted() {
    //this.draw();

    this.getJson();
    setInterval(this.getJson.bind(this), 5000);

    //this.chinaConfigure();
    this.chongqingConfigure(this.arr);
    //this.displayBarGraph();
    this.displayFoldLine();
    this.displayPieChart([600, 400, 200]);
  },

  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },

  methods: {
    displayFoldLine(params1, params2, params3) {
      var myChart = echarts.init(document.getElementById("fold-line"));
      var option = {
        title: {
          text: "2018年行业月收入对比"
          // subtext: "纯属虚构"
        },
        tooltip: {
          trigger: "axis"
        },
        legend: {
          data: ["电信", "移动", "联通"]
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: { show: false, type: ["line", "bar"] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        calculable: true,
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
            data: ["一月", "二月", "三月", "四月", "五月", "六月","七月", "八月", "九月", "十月", "十一月", "十二月"]
          }
        ],
        yAxis: [
          {
            type: "value",
            axisLabel: {
              formatter: "{value} 万元"
            }
          }
        ],
        series: [
          {
            name: "电信",
            type: "line",
            data: params1 || [6, 6, 6, 6, 6, 6, 6,6, 6, 6, 6, 6, 6, 6],
            markPoint: {
              data: [
                { type: "max", name: "最大值" },
                { type: "min", name: "最小值" }
              ]
            },
            markLine: {
              data: [{ type: "average", name: "平均值" }]
            }
          },
          {
            name: "移动",
            type: "line",
            data: params2 || [4, 4, 4, 4, 4, 4, 4,4, 4, 4, 4, 4, 4, 4],
            markPoint: {
              data: [
                { type: "max", name: "最大值" },
                { type: "min", name: "最小值" }
              ]
            },
            markLine: {
              data: [{ type: "average", name: "平均值" }]
            }
          },
          {
            name: "联通",
            type: "line",
            data: params3 || [2, 2, 2, 2, 2, 2, 2,2, 2, 2, 2, 2, 2, 2],
            markPoint: {
              data: [{ name: "周最低", value: -2, xAxis: 1, yAxis: -1.5 }]
            },
            markLine: {
              data: [{ type: "average", name: "平均值" }]
            }
          }
        ]
      };
      myChart.setOption(option);
    },
    displayPieChart(params4) {
      var myChart = echarts.init(document.getElementById("pie-chart"));
      var option = {
        title: {
          text: "当月用户占比",
          // subtext: "纯属虚构",
          x: "center"
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          x: "left",
          data: ["中国电信", "中国移动", "中国联通"]
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: {
              show: true,
              type: ["pie", "funnel"],
              option: {
                funnel: {
                  x: "25%",
                  width: "50%",
                  funnelAlign: "left",
                  max: 1548
                }
              }
            },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        calculable: true,
        series: [
          {
            name: "用户比",
            type: "pie",
            radius: "55%",
            center: ["50%", "60%"],
            data: [
              { value: params4[0], name: "中国电信" },
              { value: params4[1], name: "中国移动" },
              { value: params4[2], name: "中国联通" }
            ]
          }
        ]
      };
      myChart.setOption(option);
    },
    displayBarGraph() {
      var myChart = echarts.init(document.getElementById("bar-graph"));
      // 指定图表的配置项和数据
      var option = {
        title: {
          text: "ECharts 入门示例"
        },
        tooltip: {},
        legend: {
          data: ["销量"]
        },
        xAxis: {
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
        },
        yAxis: {},
        series: [
          {
            name: "销量",
            type: "bar",
            data: [5, 20, 36, 10, 10, 20]
          }
        ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
    getJson() {
      let that = this;
      fetch("http://192.168.253.1:8080/MyTelecomWeb/ReportTest")
        .then(function(response) {
          //alert(1);

          return response.json();
        })
        .then(function(json) {
          //alert(json);
          // console.log(json);
          that.arr = json;
          that.chongqingConfigure(json);
          //that.displayFoldLine();
          //that.displayPieChart([600, 400, 200]);
        })
        .catch(function(ex) {
          console.log("parsing failed", ex);
        });
    },

    chongqingConfigure(arr) {
      //set table data
      //异网渠道
      document.getElementById("ywqd1").innerHTML = arr[2][0].channel_num;
      document.getElementById("ywqd2").innerHTML = arr[2][1].channel_num;
      //本网渠道
      document.getElementById("bwqd1").innerHTML = arr[1][0].channel_num;
      document.getElementById("bwqd2").innerHTML = arr[1][1].channel_num;
      document.getElementById("bwqd3").innerHTML = arr[1][2].channel_num;
      document.getElementById("bwqd4").innerHTML = arr[1][3].channel_num;
      document.getElementById("bwqd5").innerHTML = arr[1][4].channel_num;
      //存量用户
      document.getElementById("clyh1").innerHTML = arr[3][0].user_num;
      document.getElementById("clyh2").innerHTML = arr[3][1].user_num;
      document.getElementById("clyh3").innerHTML = arr[3][2].user_num;
      //全市概况渝中区
      document.getElementById("qsgk11").innerHTML = arr[0][1].tenement_num;
      document.getElementById("qsgk12").innerHTML = arr[0][1].population;
      document.getElementById("qsgk13").innerHTML = arr[0][1].FBI_num;
      document.getElementById("qsgk14").innerHTML = arr[0][1].broadband_num;
      document.getElementById("qsgk15").innerHTML = arr[0][1].IPTV_num;
      document.getElementById("qsgk16").innerHTML = arr[0][1].otherIPTV_num;
      //全市概况渝北区
      document.getElementById("qsgk21").innerHTML = arr[0][0].tenement_num;
      document.getElementById("qsgk22").innerHTML = arr[0][0].population;
      document.getElementById("qsgk23").innerHTML = arr[0][0].FBI_num;
      document.getElementById("qsgk24").innerHTML = arr[0][0].broadband_num;
      document.getElementById("qsgk25").innerHTML = arr[0][0].IPTV_num;
      document.getElementById("qsgk26").innerHTML = arr[0][0].otherIPTV_num;
      //全市概况南岸区
      document.getElementById("qsgk31").innerHTML = arr[0][2].tenement_num;
      document.getElementById("qsgk32").innerHTML = arr[0][2].population;
      document.getElementById("qsgk33").innerHTML = arr[0][2].FBI_num;
      document.getElementById("qsgk34").innerHTML = arr[0][2].broadband_num;
      document.getElementById("qsgk45").innerHTML = arr[0][2].IPTV_num;
      document.getElementById("qsgk56").innerHTML = arr[0][2].otherIPTV_num;
      //全市概况江北区
      document.getElementById("qsgk41").innerHTML = arr[0][3].tenement_num;
      document.getElementById("qsgk42").innerHTML = arr[0][3].population;
      document.getElementById("qsgk43").innerHTML = arr[0][3].FBI_num;
      document.getElementById("qsgk44").innerHTML = arr[0][3].broadband_num;
      document.getElementById("qsgk45").innerHTML = arr[0][3].IPTV_num;
      document.getElementById("qsgk46").innerHTML = arr[0][3].otherIPTV_num;
      //全市概况沙坪坝区
      document.getElementById("qsgk51").innerHTML = arr[0][5].tenement_num;
      document.getElementById("qsgk52").innerHTML = arr[0][5].population;
      document.getElementById("qsgk53").innerHTML = arr[0][5].FBI_num;
      document.getElementById("qsgk54").innerHTML = arr[0][5].broadband_num;
      document.getElementById("qsgk55").innerHTML = arr[0][5].IPTV_num;
      document.getElementById("qsgk56").innerHTML = arr[0][5].otherIPTV_num;
      //全市概况九龙坡区
      document.getElementById("qsgk61").innerHTML = arr[0][4].tenement_num;
      document.getElementById("qsgk62").innerHTML = arr[0][4].population;
      document.getElementById("qsgk63").innerHTML = arr[0][4].FBI_num;
      document.getElementById("qsgk64").innerHTML = arr[0][4].broadband_num;
      document.getElementById("qsgk65").innerHTML = arr[0][4].IPTV_num;
      document.getElementById("qsgk66").innerHTML = arr[0][4].otherIPTV_num;

      let testarr = arr;
      let that = this;

      var myChart = echarts.init(document.getElementById("sichuan"));
      var option = {
        title: {
          text: "重庆市电子化作战云地图"
          //subtext: '-。-'  //子标题
        },
        tooltip: {
          trigger: "item",
          formatter: function(params) {
            // console.log(params["name"])
            var res = "";
            res += params["data"].name + "</br>";
            res += "住户数" + " : " + params["data"].value + "</br>";
            res += "人口数" + " : " + params["data"].value2 + "</br>";
            return res;
          }
        },

        legend: {
          orient: "vertical",
          x: "right",
          data: ["数据名称"]
        },
        visualMap: {
          min: 800,
          max: 50000,
          text: ["High", "Low"],
          realtime: false,
          calculable: true,
          inRange: {
            color: ["lightskyblue", "yellow", "orangered"]
          }
        },
        series: [
          {
            //name: '数据名称',
            type: "map",
            roam: true,
            mapType: "重庆", //如果是其他省份，也可以改变，例如：上海，北京，天津等地。
            selectedMode: "single",
            // itemStyle: {
            //   normal: {
            //     label: { show: true },
            //     borderWidth: 2, //省份的边框宽度
            //     childBorderWidth: 1,
            //     childBorderColor: "#6EA1F4"
            //   },
            //   emphasis: { label: { show: true } }
            // },
            itemStyle: {
              normal: { label: { show: true } },
              emphasis: { label: { show: true } }
            },
            data: [
              { name: "奉节县", value: 12345, value2: 12345 },
              { name: "巫溪县", value: 12345, value2: 12345 },
              { name: "开州区", value: 12345, value2: 12345 },
              { name: "酉阳土家族苗族自治县", value: 12345, value2: 12345 },
              { name: "彭水苗族土家族自治县", value: 12345, value2: 12345 },
              { name: "云阳县", value: 12345, value2: 12345 },
              { name: "万州区", value: 12345, value2: 12345 },
              { name: "城口县", value: 12345, value2: 12345 },
              { name: "江津区", value: 12345, value2: 12345 },
              { name: "石柱土家族自治县", value: 12345, value2: 12345 },
              { name: "巫山县", value: 12345, value2: 12345 },
              { name: "涪陵区", value: 12345, value2: 12345 },
              { name: "丰都县", value: 12345, value2: 12345 },
              { name: "武隆区", value: 12345, value2: 12345 },
              { name: "南川区", value: 12345, value2: 12345 },
              { name: "秀山土家族苗族自治县", value: 12345, value2: 12345 },
              { name: "黔江区", value: 12345, value2: 12345 },
              { name: "合川区", value: 12345, value2: 12345 },
              { name: "綦江区", value: 12345, value2: 12345 },
              { name: "忠县", value: 12345, value2: 12345 },
              { name: "梁平县", value: 12345, value2: 12345 },
              { name: "巴南区", value: 12345, value2: 12345 },
              { name: "潼南区", value: 12345, value2: 12345 },
              { name: "永川区", value: 12345, value2: 12345 },
              { name: "垫江县", value: 12345, value2: 12345 },
              { name: "渝北区", value: arr[0][0].tenement_num, value2: arr[0][0].population },
              { name: "长寿区", value: 12345, value2: 12345 },
              { name: "大足区", value: 12345, value2: 12345 },
              { name: "铜梁区", value: 12345, value2: 12345 },
              { name: "荣昌区", value: 12345, value2: 12345 },
              { name: "璧山区", value: 12345, value2: 12345 },
              { name: "北碚区", value: 12345, value2: 12345 },
              { name: "万盛区", value: 12345, value2: 12345 },
              { name: "九龙坡区", value: arr[0][4].tenement_num, value2: arr[0][4].population },
              { name: "沙坪坝区", value: arr[0][5].tenement_num, value2: arr[0][5].population },
              { name: "南岸区", value: arr[0][2].tenement_num, value2: arr[0][2].population },
              { name: "江北区", value: arr[0][3].tenement_num, value2: arr[0][3].population },
              { name: "大渡口区", value: 12345, value2: 12345 },
              { name: "渝中区", value: arr[0][1].tenement_num, value2: arr[0][1].population }
            ]
          }
        ]
      };
      myChart.setOption(option);
      myChart.on("click", function(params) {
        //console.log(params.name)
        if (params.name == "江北区") {
          
          let params1 = [arr[4][0].Month_1,arr[4][0].Month_2,arr[4][0].Month_3,arr[4][0].Month_4,arr[4][0].Month_5,arr[4][0].Month_6 ,arr[4][0].Month_7,arr[4][0].Month_8,arr[4][0].Month_9,arr[4][0].Month_10,arr[4][0].Month_11,arr[4][0].Month_12 ];
          let params2 = [arr[4][1].Month_1,arr[4][1].Month_2,arr[4][1].Month_3,arr[4][1].Month_4,arr[4][1].Month_5,arr[4][1].Month_6 ,arr[4][1].Month_7,arr[4][1].Month_8,arr[4][1].Month_9,arr[4][1].Month_10,arr[4][1].Month_11,arr[4][1].Month_12 ];
          let params3 = [arr[4][2].Month_1,arr[4][2].Month_2,arr[4][2].Month_3,arr[4][2].Month_4,arr[4][2].Month_5,arr[4][2].Month_6 ,arr[4][2].Month_7,arr[4][2].Month_8,arr[4][2].Month_9,arr[4][2].Month_10,arr[4][2].Month_11,arr[4][2].Month_12 ];
          // console.log(12121212121);
          // console.log(params1);
          var params11 = [];
          var params12 = [];
          var params13 = [];
          for(let i = 0;i<12;i++){
            if(params1[i]!=0){
              params11[i] = params1[i];
              params12[i] = params2[i];
              params13[i] = params3[i];
            }
          }
          that.displayFoldLine(params11, params12, params13);
          let params4 = [arr[4][0].M_userPer, arr[4][1].M_userPer, arr[4][2].M_userPer];
          that.displayPieChart(params4);
        };
        if (params.name == "九龙坡区") {
          let params1 = [arr[4][3].Month_1,arr[4][3].Month_2,arr[4][3].Month_3,arr[4][3].Month_4,arr[4][3].Month_5,arr[4][3].Month_6,arr[4][3].Month_7,arr[4][3].Month_8,arr[4][3].Month_9,arr[4][3].Month_10,arr[4][3].Month_11,arr[4][3].Month_12  ];
          let params2 = [arr[4][4].Month_1,arr[4][4].Month_2,arr[4][4].Month_3,arr[4][4].Month_4,arr[4][4].Month_5,arr[4][4].Month_6 ,arr[4][4].Month_7,arr[4][4].Month_8,arr[4][4].Month_9,arr[4][4].Month_10,arr[4][4].Month_11,arr[4][4].Month_12];
          let params3 = [arr[4][5].Month_1,arr[4][5].Month_2,arr[4][5].Month_3,arr[4][5].Month_4,arr[4][5].Month_5,arr[4][5].Month_6 ,arr[4][5].Month_7,arr[4][5].Month_8,arr[4][5].Month_9,arr[4][5].Month_10,arr[4][5].Month_11,arr[4][5].Month_12 ];
          var params11 = [];
          var params12 = [];
          var params13 = [];
          for(let i = 0;i<12;i++){
            if(params1[i]!=0){
              params11[i] = params1[i];
              params12[i] = params2[i];
              params13[i] = params3[i];
            }
          }
          that.displayFoldLine(params11, params12, params13);
          let params4 = [arr[4][3].M_userPer, arr[4][4].M_userPer, arr[4][5].M_userPer];
          that.displayPieChart(params4);
        };
        if (params.name == "南岸区") {
          let params1 = [arr[4][9].Month_1,arr[4][9].Month_2,arr[4][9].Month_3,arr[4][9].Month_4,arr[4][9].Month_5,arr[4][9].Month_6 ,arr[4][9].Month_7,arr[4][9].Month_8,arr[4][9].Month_9,arr[4][9].Month_10,arr[4][9].Month_11,arr[4][9].Month_12 ];
          let params2 = [arr[4][10].Month_1,arr[4][10].Month_2,arr[4][10].Month_3,arr[4][10].Month_4,arr[4][10].Month_5,arr[4][10].Month_6 ,arr[4][10].Month_7,arr[4][10].Month_8,arr[4][10].Month_9,arr[4][10].Month_10,arr[4][10].Month_11,arr[4][10].Month_12 ];
          let params3 = [arr[4][11].Month_1,arr[4][11].Month_2,arr[4][11].Month_3,arr[4][11].Month_4,arr[4][11].Month_5,arr[4][11].Month_6 ,arr[4][11].Month_7,arr[4][11].Month_8,arr[4][11].Month_9,arr[4][11].Month_10,arr[4][11].Month_11,arr[4][11].Month_12 ];
          var params11 = [];
          var params12 = [];
          var params13 = [];
          for(let i = 0;i<12;i++){
            if(params1[i]!=0){
              params11[i] = params1[i];
              params12[i] = params2[i];
              params13[i] = params3[i];
            }
          }
          that.displayFoldLine(params11, params12, params13);
          let params4 = [arr[4][9].M_userPer, arr[4][10].M_userPer, arr[4][11].M_userPer];
          that.displayPieChart(params4);
        };
        if (params.name == "渝中区") {
          let params1 = [arr[4][15].Month_1,arr[4][15].Month_2,arr[4][15].Month_3,arr[4][15].Month_4,arr[4][15].Month_5,arr[4][15].Month_6 ,arr[4][15].Month_7,arr[4][15].Month_8,arr[4][15].Month_9,arr[4][15].Month_10,arr[4][15].Month_11,arr[4][15].Month_12];
          let params2 = [arr[4][16].Month_1,arr[4][16].Month_2,arr[4][16].Month_3,arr[4][16].Month_4,arr[4][16].Month_5,arr[4][16].Month_6 ,arr[4][16].Month_7,arr[4][16].Month_8,arr[4][16].Month_9,arr[4][16].Month_10,arr[4][16].Month_11,arr[4][16].Month_12 ];
          let params3 = [arr[4][17].Month_1,arr[4][17].Month_2,arr[4][17].Month_3,arr[4][17].Month_4,arr[4][17].Month_5,arr[4][17].Month_6 ,arr[4][17].Month_7,arr[4][17].Month_8,arr[4][17].Month_9,arr[4][17].Month_10,arr[4][17].Month_11,arr[4][17].Month_12  ];
          var params11 = [];
          var params12 = [];
          var params13 = [];
          for(let i = 0;i<12;i++){
            if(params1[i]!=0 && params2[i]!=0 && params3[i]!=0){
              params11[i] = params1[i];
              params12[i] = params2[i];
              params13[i] = params3[i];
            }
          }
          that.displayFoldLine(params11, params12, params13);
          let params4 = [arr[4][15].M_userPer, arr[4][16].M_userPer, arr[4][17].M_userPer];
          that.displayPieChart(params4);
        };
        if (params.name == "渝北区") {
          let params1 = [arr[4][12].Month_1,arr[4][12].Month_2,arr[4][12].Month_3,arr[4][12].Month_4,arr[4][12].Month_5,arr[4][12].Month_6 ,arr[4][12].Month_7,arr[4][12].Month_8,arr[4][12].Month_9,arr[4][12].Month_10,arr[4][12].Month_11,arr[4][12].Month_12 ];
          let params2 = [arr[4][13].Month_1,arr[4][13].Month_2,arr[4][13].Month_3,arr[4][13].Month_4,arr[4][13].Month_5,arr[4][13].Month_6 ,arr[4][13].Month_7,arr[4][13].Month_8,arr[4][13].Month_9,arr[4][13].Month_10,arr[4][13].Month_11,arr[4][13].Month_12 ];
          let params3 = [arr[4][14].Month_1,arr[4][14].Month_2,arr[4][14].Month_3,arr[4][14].Month_4,arr[4][14].Month_5,arr[4][14].Month_6 ,arr[4][14].Month_7,arr[4][14].Month_8,arr[4][14].Month_9,arr[4][14].Month_10,arr[4][14].Month_11,arr[4][14].Month_12 ];
          var params11 = [];
          var params12 = [];
          var params13 = [];
          for(let i = 0;i<12;i++){
            if(params1[i]!=0){
              params11[i] = params1[i];
              params12[i] = params2[i];
              params13[i] = params3[i];
            }
          }
          that.displayFoldLine(params11, params12, params13);
          let params4 = [arr[4][12].M_userPer, arr[4][13].M_userPer, arr[4][14].M_userPer];
          that.displayPieChart(params4);
        };
        if (params.name == "沙坪坝区") {
          let params1 = [arr[4][6].Month_1,arr[4][6].Month_2,arr[4][6].Month_3,arr[4][6].Month_4,arr[4][6].Month_5,arr[4][6].Month_6 ,arr[4][6].Month_7,arr[4][6].Month_8,arr[4][6].Month_9,arr[4][6].Month_10,arr[4][6].Month_11,arr[4][6].Month_12 ];
          let params2 = [arr[4][7].Month_1,arr[4][7].Month_2,arr[4][7].Month_3,arr[4][7].Month_4,arr[4][7].Month_5,arr[4][7].Month_6 ,arr[4][7].Month_7,arr[4][7].Month_8,arr[4][7].Month_9,arr[4][7].Month_10,arr[4][7].Month_11,arr[4][7].Month_12 ];
          let params3 = [arr[4][8].Month_1,arr[4][8].Month_2,arr[4][8].Month_3,arr[4][8].Month_4,arr[4][8].Month_5,arr[4][8].Month_6 ,arr[4][8].Month_7,arr[4][8].Month_8,arr[4][8].Month_9,arr[4][8].Month_10,arr[4][8].Month_11,arr[4][8].Month_12 ];
          var params11 = [];
          var params12 = [];
          var params13 = [];
          // console.log(params1);
          for(let i = 0;i<12;i++){
            if(params1[i]!=0){
              params11[i] = params1[i];
              // console.log(params11[i]);
              params12[i] = params2[i];
              params13[i] = params3[i];
            }
          }
          that.displayFoldLine(params11, params12, params13);
          let params4 = [arr[4][0].M_userPer, arr[4][1].M_userPer, arr[4][2].M_userPer];
          that.displayPieChart(params4);
        };
      });
    }
  }
};
</script>

<style>
#sichuan {
  height: 800px;
  width: 800px;
  text-align: center;
}

#app {
  position: relative;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.table-container1 {
  position: absolute;
  top: 200px;
  right: 60px;
  /* height: 100px; */
  /* width: 100px; */
  border: 1px solid red;
}
.table-container2 {
  position: absolute;
  top: 300px;
  right: 200px;
  /* height: 100px; */
  /* width: 100px; */
  border: 1px solid red;
}
.table-container3 {
  position: absolute;
  top: 200px;
  right: 200px;
  /* height: 100px; */
  /* width: 100px; */
  border: 1px solid red;
}
.table-container4 {
  position: absolute;
  top: 400px;
  right: 60px;
  /* height: 100px; */
  /* width: 100px; */
  border: 1px solid red;
}
#analysis {
  width: 100%;
  display: table;
}

/* #bar-graph {
  height: 500px;
  width: 50%;
  color: #ff0000;
  text-align: left;
  float: left;
} */

#fold-line {
  height: 400px;
  width: 50%;
  color: #ff0000;
  text-align: left;
  float: left;
}
#pie-chart {
  height: 400px;
  width: 50%;
  color: #ff0000;
  text-align: right;
  float: left;
}
#test {
  font-weight: bold;
  color: #ff0000;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
