public class SocialMediaPost {

    private String postId;
    private String platform;
    private String content;

    public SocialMediaPost(String postId, String platform, String content) {
        this.postId = postId;
        this.platform = platform;
        this.content = content;
    }

    public String getPostId() { return postId; }
    public String getPlatform() { return platform; }
    public String getContent() { return content; }

    public void setPostId(String postId) { this.postId = postId; }
    public void setPlatform(String platform) { this.platform = platform; }
    public void setContent(String content) { this.content = content; }

    public void showInfo() {
        System.out.println("Post ID: " + postId);
        System.out.println("Plataforma: " + platform);
        System.out.println("Contenido: " + content);
        System.out.println("-----------------------------------");
    }
}
