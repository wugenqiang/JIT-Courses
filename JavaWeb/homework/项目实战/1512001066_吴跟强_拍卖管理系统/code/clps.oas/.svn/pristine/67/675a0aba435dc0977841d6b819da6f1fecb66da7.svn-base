/**    
 * @Title: FileUploadDownloadController.java  
 * @Package com.clps.oas.util.file  
 * @Description: FileUploadDownloadController 
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-17  11:29:16
 * @version V1.0    
 */
package com.clps.oas.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: FileUploadDownloadController
 * @Description: FileUploadDownloadController
 * @author weigion.wu
 * @date 2018-05-17 11:29:16
 */

@Controller
@RequestMapping(value = "/file")
public class FileUploadDownloadController {

	private Logger logger = Logger.getLogger(FileUploadDownloadController.class);

	// 定位到上传的文件界面 /clps.oas/file/fileUpload
	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public String showUploadPage() {
		return "util/file/file_upload";
	}

	// 上传文件之后操作
	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		// 获得项目的路径
		ServletContext sc = request.getSession().getServletContext();
		// 上传位置
		String path = sc.getRealPath("/fileUpload") + "/"; // 设定文件保存的目录
		File f = new File(path);
		if (!f.exists())
			f.mkdirs();
		// 获得原始文件名
		String fileName = file.getOriginalFilename();
		logger.info("原始文件名:" + fileName);
		// 创建新文件名
		String newFileName = UUID.randomUUID() + fileName;
		if (!file.isEmpty()) {
			try {
				FileOutputStream fos = new FileOutputStream(path + newFileName);
				InputStream in = file.getInputStream();
				int b = 0;
				while ((b = in.read()) != -1) {
					fos.write(b);
				}
				fos.close();
				in.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}else{
			logger.info("上传文件不存在！！！");
			return "redirect:/file/fileUpload";
		}
		logger.info("上传文件到:" + path + newFileName);

		return "util/file/file_upload_success";
	}

	// 定位到文件列表显示 /clps.oas/file/fileList
	@RequestMapping(value = "/fileList", method = RequestMethod.GET)
	public String showFileListPage(HttpServletRequest request, HttpServletResponse response) {

		// 获取上传文件的目录
		ServletContext sc = request.getSession().getServletContext();
		// 上传位置
		String uploadFilePath = sc.getRealPath("/fileUpload") + "/"; // 设定文件保存的目录
		// 存储要下载的文件名
		Map<String, String> fileNameMap = new HashMap<String, String>();
		// 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
		fileList(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录
		// 将Map集合发送到listfile.jsp页面进行显示
		request.setAttribute("fileNameMap", fileNameMap);

		return "util/file/file_list";
	}

	// 递归遍历，将文件的文件名存储到map集合中
	public void fileList(File file, Map<String, String> map) {
		// 如果file代表的不是一个文件，而是一个目录
		if (!file.isFile()) {
			// 列出该目录下的所有文件和目录
			File files[] = file.listFiles();
			// 遍历files[]数组
			for (File f : files) {
				// 递归
				fileList(f, map);
			}
		} else {

			String realName = file.getName().substring(file.getName().indexOf("_") + 1);
			// file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
			map.put(file.getName(), realName);
		}
	}

	// 文件下载
	@RequestMapping("/fileDownload")
	public void downFile(HttpServletRequest request, HttpServletResponse response) {
		// 下载文件名
		String fileName = request.getParameter("fileName");
		try {
			// fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");

			// 获取上传文件的目录
			ServletContext sc = request.getSession().getServletContext();

			// 上传位置
			String fileSaveRootPath = sc.getRealPath("/fileUpload");

			logger.info(fileSaveRootPath + "\\" + fileName);
			// 得到要下载的文件
			File file = new File(fileSaveRootPath + "\\" + fileName);

			// 如果文件不存在
			if (!file.exists()) {
				request.setAttribute("message", "您要下载的文件已被删除！！");
				logger.info("您要下载的文件已被删除！！");
			}
			// 处理文件名
			String realName = fileName.substring(fileName.indexOf("_") + 1);
			// 设置响应头，控制浏览器下载该文件
			response.setContentType("application;charset=UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realName, "UTF-8"));
			// 读取要下载的文件，保存到文件输入流
			FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);
			// 创建输出流
			OutputStream out = response.getOutputStream();
			// 创建缓冲区
			byte buffer[] = new byte[1024];
			int len = 0;
			// 循环将输入流中的内容读取到缓冲区当中
			while ((len = in.read(buffer)) > 0) {
				// 输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
			}
			// 关闭文件输入流
			in.close();
			// 关闭输出流
			out.close();
		} catch (Exception e) {
			logger.error(e.getMessage());

		}
	}

}
