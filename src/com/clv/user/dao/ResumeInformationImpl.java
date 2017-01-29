package com.clv.user.dao;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

public class ResumeInformationImpl implements ResumeInformation {

	@Override
	public String identityAuthentication(int id, String name, String gender, String idNum) throws JSONException {
		return null;
	}

	@Override
	public String modifyIdentityAuthentication(int id, String name, String gender, String idNum) throws JSONException {
		return null;
	}

	@Override
	public String uploadCertificatePhoto(int id, int type, MultipartFile file, HttpServletRequest reques)
			throws JSONException {
		return null;
	}

	@Override
	public String selectIdentityAuditConclusion(int id) throws JSONException {
		return null;
	}

	@Override
	public String modifyHeight(int id, int height) throws JSONException {
		return null;
	}

	@Override
	public String modifyEmail(int id, String eMail) throws JSONException {
		return null;
	}

	@Override
	public String getInformation(int id) throws JSONException {
		return null;
	}

	@Override
	public String getAuditQueue(int adminId) throws JSONException {
		return null;
	}

	@Override
	public String selectIdentity(int adminId, int user_id) throws JSONException {
		return null;
	}

	@Override
	public String setAuditConclusion(int adminId, int user_id, int auditType) throws JSONException {
		return null;
	}

}
