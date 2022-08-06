package com.api.steps;

import org.json.JSONException;
import com.api.utils.ApiUtils;

public class ConstructPayload {
	
	ApiUtils apiUtils = new ApiUtils();
	
	
	public String constructLoginPayload(String filepath, String email, String password) throws JSONException {
		String payload = apiUtils.getFile(filepath);
		payload = payload.replace("{{email}}", email);
		payload = payload.replace("{{password}}", ApiUtils.base64Decode(password));
		return payload;
	}

	public String constructAddUserPayload(String filepath, String name, String email, String password) throws JSONException {
		String payload = apiUtils.getFile(filepath);
		payload = payload.replace("{{name}}", name);
		payload = payload.replace("{{email}}", email);
		payload = payload.replace("{{password}}", password);
		return payload;
	}

}
