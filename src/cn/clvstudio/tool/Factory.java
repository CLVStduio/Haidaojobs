package cn.clvstudio.tool;

/**
 * 工厂各工具类聚集
 * @author Evanglist
 * @time 2016.12.31
 */
public class Factory {
	public FileProcessing getPhotoProcessing(){
		return new FileProcessing();
	}
	
	public Crypto getCrypto() {
		return new Crypto();
	}
	public Json getJson() {
		return new Json();
	}
	public BuilderKey getBKey() {
		return new BuilderKey();
	}
		
}
