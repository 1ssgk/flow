<style>
.top-bar{
  background: rgb(240, 240, 240);
}
</style>

<template>
  <div id="app">
    <v-app id="inspire">
      <v-app id="keep">
        <v-main class="align-center">
          <v-container
            fluid
            class="white"
          >
            <router-view :style="{height:`40%`,width:`50%`}"></router-view>
          </v-container>
        </v-main>
      </v-app>
    </v-app>
  </div>
</template>

<script>


export default {
  name: 'App',
  
  data: () => ({
  }),
  props: {
  },
  created() {
  },
  methods:{
  },
}
</script>