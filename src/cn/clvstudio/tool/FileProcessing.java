package cn.clvstudio.tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件相关 操作
 * @author Evanglist
 * @time 2017.01.02
 */
public class FileProcessing{
	
	/**
	 * 应用根目录
	 */
	private String pathRoot = "C:\\Users\\Administrator\\Desktop\\Html\\haidaojobs";
	/**
	 * 保存文件
	 * @param fileName
	 * 			本地文件名
	 * @param path
	 * 			相对路径
	 * @param file
	 * 			上传的文件数据
	 */
	public void savefile(String fileName,String path,MultipartFile file){
		File fileDir = new File(pathRoot+path);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		
		try {
			FileOutputStream out = new FileOutputStream(fileDir+File.separator+fileName);
			out.write(file.getBytes());
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除文件
	 * @param path
	 * 		文件的地址
	 */
	public void deleteFile(String path){
		File file = new File(pathRoot+path);
		if(file.isFile() && file.exists()){
			file.delete();
		}
	}
	
	/**
	 * 查询指定目录下的所有文件
	 * @param path
	 * 		相对路径
	 * @param type
	 * 		文件类型
	 * @return
	 * @throws JSONException
	 */
	public JSONArray selectFileForDir(String path,String type) throws JSONException{
		File dir = new File(pathRoot+path);
		JSONArray jArray = new JSONArray();
		if(dir.isDirectory() && dir.exists()){
			File[] files = dir.listFiles();
			if("Image".equals(type)){
				for(File file : files){
					if(file.isFile() && isImage(file.getName().substring(file.getName().indexOf(".")+1))){
						JSONObject json = new JSONObject();
						json.put("photoName", file.getName());
						jArray.put(json);
					}
				}
			}
		}
		return jArray;
	}
	
	/**
	 * 查询指定目录下的所有文件
	 * @param path
	 * 		相对路径
	 * @return
	 * @throws JSONException
	 */
	public JSONArray selectFileForDir(String path) throws JSONException{
		File dir = new File(pathRoot+path);
		JSONArray jArray = new JSONArray();
		if(dir.isDirectory() && dir.exists()){
			File[] files = dir.listFiles();
			for(File file : files){
				if(file.isFile() && isImage(file.getName().substring(file.getName().indexOf(".")+1))){
					JSONObject json = new JSONObject();
					json.put("Name", file.getName());
					jArray.put(json);
				}
			}
		}
		return jArray;
	}
	/**
	 * 判断是否是图片格式
	 * @param imagesPattern
	 * 		文件的后缀名
	 * @return
	 */
	public boolean isImage(String imagesPattern){  
        if("jpg".equals(imagesPattern)){  
            return true;  
        }else if("bmp".equals(imagesPattern)){  
            return true;  
        }else if("gif".equals(imagesPattern)){  
            return true;  
        }else if("psd".equals(imagesPattern)){  
            return true;  
        }else if("pcx".equals(imagesPattern)){  
            return true;  
        }else if("png".equals(imagesPattern)){  
            return true;  
        }else if("dxf".equals(imagesPattern)){  
            return true;  
        }else if("cdr".equals(imagesPattern)){  
            return true;  
        }else if("ico".equals(imagesPattern)){  
            return true;  
        }else if("bmp".equals(imagesPattern)){  
            return true;  
        }else if("jpeg".equals(imagesPattern)){  
            return true;  
        }else if("svg".equals(imagesPattern)){  
            return true;  
        }else if("wmf".equals(imagesPattern)){  
            return true;  
        }else if("emf".equals(imagesPattern)){  
            return true;  
        }else if("eps".equals(imagesPattern)){  
            return true;  
        }else if("tga".equals(imagesPattern)){  
            return true;  
        }else if("nef".equals(imagesPattern)){  
            return true;  
        }else if("tif".equals(imagesPattern)){  
            return true;  
        }else if("tiff".equals(imagesPattern)){  
            return true;  
        }else{  
            return false;  
        }  
  
    }  
}