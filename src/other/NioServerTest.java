package other;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServerTest {

    public static void main(String[] args) throws Exception {

        Selector selector = Selector.open();//打开Selector 多路复用注册器
        ServerSocketChannel socketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(81));//打开通道绑定地址

        socketChannel.configureBlocking(false);// 设置非阻塞

        ByteBuffer allocate = ByteBuffer.allocate(1024);//buffer

        socketChannel.register(selector, SelectionKey.OP_ACCEPT);// 注册到selector

        System.out.println("start ----------");
        while (true) {
            if (selector.select() > 0) {//新事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();//所有事件
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    if (next.isAcceptable()) {//就绪请求
                        System.out.println("isAccept");
                        SocketChannel channel = ((ServerSocketChannel) next.channel()).accept();
                        channel.configureBlocking(false);//非阻塞
                        channel.register(selector, SelectionKey.OP_READ);//注册on_read事件
                    }
                    if (next.isReadable()) {//写入请求
                        SocketChannel channel = (SocketChannel) next.channel();
                        int read = channel.read(allocate);//读缓存区
                        // allocate.flip();
                        if (read > 0) {//有数据写入
                            System.out.println("read:" + new String(allocate.array(), 0, read));
                        }
                        allocate.clear();
                    }
                }
                iterator.remove();
            }
        }

    }
}
