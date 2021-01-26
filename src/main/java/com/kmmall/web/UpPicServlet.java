package com.kmmall.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upPic.do")
public class UpPicServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // String
		try {
			// 判断表单是不是多类型表单
			if (ServletFileUpload.isMultipartContent(req)) {
				// 获取上传对象
				ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
				sfu.setHeaderEncoding("utf-8");
				List<FileItem> list = sfu.parseRequest(req);
//				遍历文件列表
				for (FileItem fileItem : list) {
					// 如果是input=file，则进行上传
					if (!fileItem.isFormField()) {
						String name = fileItem.getName();
						System.out.println(name);
						InputStream inputStream = fileItem.getInputStream();
						// 获取随机文件名字
						String fileName =  UUID.randomUUID().toString();
						// 获取上传文件的后缀名
						String[] split = name.split("\\.");
						fileName = fileName + "." + split[1];// 拼接后缀名到新的文件名中
						//获取上传目录
						String upload = req.getSession().getServletContext().getRealPath("upload");
						//创建该文件并写出
						File file = new File(upload+"/"+fileName);
//						进行资源拷贝
						fileItem.write(file);
						resp.getWriter().write(fileName);
						return;
					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
