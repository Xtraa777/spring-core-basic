package hello.core.lifecycle;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private void call(String msg) {
        System.out.println("call = " + url + " message = " + msg);
    }

    private void conncet() {
        System.out.println("connect: " + url);
    }

    public void disconnect() {
        System.out.println("close: " + url);
    }

    public void init() {
        System.out.println("NetworkClient.init");
        conncet();
        call("초기화 연결 메시지");
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

}
