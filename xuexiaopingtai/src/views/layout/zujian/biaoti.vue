<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <el-row class="titles">
    <el-col :span="24">
      <section>
        <ul>
          <li>
            <a><slot name="first"></slot></a>
          </li>
          <li>
            <a><slot name="second"></slot></a>
          </li>
          <li>
            <a><slot name="third"></slot></a>
          </li>
          <li>
            <a><slot name="fourth"></slot></a>
          </li>
        </ul>
      </section>
    </el-col>
  </el-row>
</template>

<script setup></script>

<style lang="scss" scoped>
.titles {
  height: 150px;
  section {
    position: absolute;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(to bottom, #1a84b8, #a7d0ef);
    ul {
      position: relative;
      display: flex;
      gap: 20px;
      li {
        list-style: none;
        -webkit-tap-highlight-color: transparent;
        a {
          z-index: 2;
          position: relative;
          top: 0;
          width: 100px;
          height: 100px;
          font-size: 5em;
          background: #ffffff1a;
          color: #fff;
          display: flex;
          justify-content: center;
          align-items: center;
          font-family: sans-serif;
          border: 1px solid #ffffff66;
          border-right: 1px solid #ffffff33;
          border-bottom: 1px solid #ffffff33;
          border-radius: 10px;
          backdrop-filter: blur(5px);
          box-shadow: 0 5px 45px #0000001a;
          text-decoration: none;
          overflow: hidden;
          transition: top 0.5s, z-index 0s, transform 0.5s;
          transition-delay: 0.5s 0.5s 0s;
          cursor: pointer;
        }

        a::before {
          content: '';
          width: 50px;
          height: 100%;
          background: #ffffff80;
          position: absolute;
          top: 0;
          left: 0;
          transform: skewX(60deg) translateX(170px);
          transition: 0.5s;
        }

        a {
          z-index: 1;
        }

        a:hover {
          z-index: 3;
          top: -50px;
          transition-delay: 0s, 0.5s, 0.5s;
          transform: translateY(50px);
        }

        a:hover:before {
          transform: skewX(45deg) translateX(-150px);
        }
      }
    }
  }
}
</style>
