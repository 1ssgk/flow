
<template>
  <v-container class="d-flex flex-column justify-center" style="">
        <v-row class="align-center">
          <v-col cols="12">
            <p class="font-weight-black text-left headline">
              ◎ 파일확장자에 따라 특정 형식의 파일을 첨부하거나 전송하지 못하도록 제한
            </p>
          </v-col>
        </v-row>
        <v-row class="align-center">
          <v-col cols="3" class="">
            <p class="font-weight-black ">
              고정 확장자
            </p>
          </v-col>
          <v-col class="d-flex" cols="9">
            <v-checkbox
              class="mx-2 my-2"
              type="number"
              :false-value="0"
              :true-value="1"
              v-for="(item, i) in $store.state.fixItems"
              :key="i"
              :id="item.name"
              :label="item.name"
              :input-value="item.selectChk"
              @change="fixExtensionClick(item.no,item.name,$event)">
            </v-checkbox>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3" class="my">
            <p class="font-weight-black">
              커스텀 확장자
            </p>
          </v-col>
          <v-col cols="6" class="">
            <v-text-field
              v-model="extension"
              label="확장자 입력"
              placeholder="최대 20자"
              solo
              maxlength="20"
              oninput="javascript: this.value = this.value.replace(/[^A-Za-z]/ig, '');"
            ></v-text-field>
          </v-col>
          <v-col class="justify-center text-center" cols="3">
            <v-btn
              color="gray"
              v-if="$store.state.customCnt != 200"
              @click="insertCustomExtension(extension)"
            >
              +추가
            </v-btn>
          </v-col>
        </v-row>
        <v-row class="" style="">
          <v-col cols="3">
            <v-spacer></v-spacer>
          </v-col>
          <v-col cols="9" class="">
            <v-card class="fill-height">
              <v-card-subtitle>
                {{$store.state.customCnt}} / 200
              </v-card-subtitle>
                <v-card-actions>
                  <v-list-item class="d-flex" style="height:300px">
                    <div class=" fill-height overflow-auto">
                      <v-chip 
                        v-for="(item, i) in $store.state.customItems"
                        :key="i"
                        class="ma-2 pa-2"
                        close
                        color="black"
                        label
                        outlined
                        :id="item.name"
                        @click:close="deleteCustomExtension(item.no,item.name)"
                      >
                        {{item.name}}
                      </v-chip>
                    </div>
                  </v-list-item>
                </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'Home',

    components: {
    },
    computed :{
      
    },
    data () {
      
      return {
        extension:"",
        custom_items:[]
        
      }
      
    },
    created() {
      // 고정, 커스텀 확장자 default 데이터 가져오기
      this.getExtensionList(this.$store);
    },
    mounted(){
    },
    methods:{
      // 고정, 커스텀 확장자 default 데이터 가져오기
      getExtensionList(store){
        store.dispatch('getExtensionList')
      },
      // 고정 확장자 체크 시 
      fixExtensionClick(no,name,value){
        let param ={
          "no"    : no
        , "name"  : name
        , "value" : value
        }

        this.$store.dispatch('updateExtension',param)
      },
      // 추가 버튼 클릭 시
      insertCustomExtension(data){

        if(!data){
          alert("확장자 명을 입력해주세요.");
          return;
        }
        this.$store.dispatch('insertCustomExtension',data)
      },
      // 커스텀 확장자 X 버튼 클릭 시
      deleteCustomExtension(no,name){
        const param = {
          "no":no
        , "name":name
        }
        this.$store.dispatch('deleteCustomExtension',param)
      },
    },
    
  }
</script>



