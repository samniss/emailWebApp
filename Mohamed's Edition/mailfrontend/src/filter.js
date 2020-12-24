import Vue from 'vue';

Vue.filter("shortentext", function (v) {
    return v.substring(0, 9) + ' ...';
})