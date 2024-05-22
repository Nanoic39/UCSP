import { ref, onMounted, onUnmounted } from 'vue';
import io from 'socket.io-client';

export default function useWebSocket(url) {
  const socket = ref(null);

  onMounted(async () => {
    try {
      socket.value = await io(url);
      console.log('WebSocket connected');
      // 你可以在这里添加监听事件
      socket.value.on('message', (message) => {
        console.log('Received message:', message);
        // 处理接收到的消息
      });
    } catch (error) {
      console.error('Failed to connect:', error);
    }
  });

  onUnmounted(() => {
    if (socket.value) {
      socket.value.close();
      console.log('WebSocket disconnected');
    }
  });

  return {
    socket,
    send(message) {
      socket.value.emit('message', message);
    },
  };
}
