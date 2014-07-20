package com.pmease.gitop.web.page.repository.source.blob.renderer;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

import com.pmease.gitop.model.Repository;
import com.pmease.gitop.web.page.repository.RepositoryPage;
import com.pmease.gitop.web.service.FileBlob;
import com.pmease.gitop.web.util.ParamUtils;

@SuppressWarnings("serial")
public class RawBlobResourceReference extends ResourceReference {

	public static final String RAW_BLOB_RESOURCE = "gitop-raw-blob";
	
	public static PageParameters paramsOf(FileBlob blob) {
		return paramsOf(blob.getRepository(), blob.getRevision(), blob.getFilePath());
	}
	
	public static PageParameters paramsOf(Repository repo, String revision, String path) {
		PageParameters params = RepositoryPage.paramsOf(repo);
		params.set("objectId", revision);
		ParamUtils.addPathToParams(path, params);
		return params;
	}
	
	public RawBlobResourceReference() {
		super(RAW_BLOB_RESOURCE);
	}

	@Override
	public IResource getResource() {
		return new RawBlobResource();
	}

}
