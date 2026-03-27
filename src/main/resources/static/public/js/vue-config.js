Vue.component('genres-menus', {
    data: function () {
      return {
          perSize: 0,
          categoryList: []
      }
    },
    methods: {
      loadCategoryList: function () {
          let url = '/api/v1/category/list'
          axios.get(url)
              .then(res => {
                  this.categoryList = res.data
                  this.perSize = Number(this.categoryList.length / 3 + 1).toFixed(0)
              })
      }
    },
    mounted() {
      this.loadCategoryList()
    },
    template: `
        <ul class="dropdown-menu multi-column columns-3">
            <li class="active">
                <div class="col-sm-4">
                    <ul class="multi-column-dropdown">
                        <li v-for="(item, index) in categoryList" v-if="index>=0 && index<perSize">
                            <a :href="'genres.html?id='+item.id">{{item.name}}</a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-4">
                    <ul class="multi-column-dropdown">
                        <li v-for="(item, index) in categoryList" v-if="index>=perSize && index<perSize*2">
                            <a :href="'genres.html?id='+item.id">{{item.name}}</a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-4">
                    <ul class="multi-column-dropdown">
                        <li v-for="(item, index) in categoryList" v-if="index>=perSize*2 && index<perSize*3">
                            <a :href="'genres.html?id='+item.id">{{item.name}}</a>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </li>
        </ul>
    `
})
