<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <el-row class="bg">
    <el-col :span="20" :offset="2" class="mains">
      <div class="card">
        <img src="@/assets/images/taj-mahal.jpg" class="image" />
        <img src="@/assets/images/taj-mahal.jpg" class="background" />
        <div class="layer">
          <div class="info">
            <h1>Taj Mahal</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, placeat.</p>
          </div>
        </div>
      </div>
      <div class="card">
        <img src="@/assets/images/marina-bay.jpg" class="image" />
        <img src="@/assets/images/marina-bay.jpg" class="background" />
        <div class="layer">
          <div class="info">
            <h1>Marina Bay</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, placeat.</p>
          </div>
        </div>
      </div>
      <div class="card">
        <img src="@/assets/images/great-wall.jpg" class="image" />
        <img src="@/assets/images/great-wall.jpg" class="background" />
        <div class="layer">
          <div class="info">
            <h1>Great Wall</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, placeat.</p>
          </div>
        </div>
      </div>
      <div class="card">
        <img src="@/assets/images/statue-liberty.jpg" class="image" />
        <img src="@/assets/images/statue-liberty.jpg" class="background" />
        <div class="layer">
          <div class="info">
            <h1>Statue Liberty</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, placeat.</p>
          </div>
        </div>
      </div>
      <div class="card">
        <img src="@/assets/images/fuji-mountain.jpg" class="image" />
        <img src="@/assets/images/fuji-mountain.jpg" class="background" />
        <div class="layer">
          <div class="info">
            <h1>Fuji Mountain</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, placeat.</p>
          </div>
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script setup></script>

<style lang="scss" scoped>
.bg:before {
  content: '';
  background-image: url(@/assets/images/great-wall.jpg);
  position: absolute;
  width: 100%;
  height: 600px;
  background-size: cover;
  background-position: center;
  filter: brightness(0.25);
  z-index: -1;
}
.bg {
  .mains {
    width: 600px;
    height: 500px;
    margin-top: 50px;
    display: flex;
    gap: 15px;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
    color: white;
    .card {
      width: 20%;
      border-radius: 15px;
      cursor: pointer;
      overflow: hidden;
      transition: 2s;
    }
    .card:hover {
      width: 80%;
    }

    .card .image {
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
    .card:hover .image {
      transform: scale(1.2);
      transition: 3s;
    }

    .card .background {
      position: absolute;
      left: 0;
      top: 0;
      height: 600px;
      z-index: -1;
      width: 100%;
      object-fit: cover;
      pointer-events: none;
      filter: brightness(0.25);
      opacity: 0;
    }
    .card:hover .background {
      opacity: 1;
    }

    .card:hover .layer .info {
      opacity: 1;
    }
    .layer {
      width: 100%;
      height: 50%;
      margin-top: -250px;
      position: relative;
      background: linear-gradient(to top, rgba(0, 0, 0, 0.9), transparent);
      .info {
        width: 260px;
        position: absolute;
        bottom: 10px;
        padding: 20px;
        opacity: 0;
        p {
          color: rgba(255, 255, 255, 0.75);
          margin-top: 5px;
        }
      }
    }
  }
}
</style>
