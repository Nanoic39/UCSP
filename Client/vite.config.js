import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import VueDevTools from 'vite-plugin-vue-devtools'

// https://vitejs.dev/config/
export default defineConfig({
<<<<<<< Updated upstream
  plugins: [vue(), VueDevTools()],
=======
  plugins: [
    vue(),
    VueDevTools(),
  ],
>>>>>>> Stashed changes
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
<<<<<<< Updated upstream
  },
  optimizeDeps: {
    include: ['jquery']
=======
>>>>>>> Stashed changes
  }
})
