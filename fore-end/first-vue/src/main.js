import Vue from 'vue'
import { Button, Cell } from 'mint-ui'
import 'mint-ui/lib/style.css'
import App from './App.vue'
import router from './router'
import store from './store'
import {Field} from 'mint-ui'

import '../node_modules/echarts/map/js/china.js' 
import '../node_modules/echarts/map/js/province/chongqing.js'
import '../node_modules/echarts/map/js/province/sichuan.js'
import '../node_modules/echarts/map/js/province/shanghai.js'
import echarts from 'echarts'

Vue.prototype.$echarts = echarts
//echarts.registerMap('world', world)

Vue.component(Cell.name,Cell)
Vue.component(Field.name,Field);

 Vue.component(Button.name, Button);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
