/*
 * This file is part of Hopsworks
 * Copyright (C) 2022, Logical Clocks AB. All rights reserved
 *
 * Hopsworks is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Hopsworks is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.  See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 */
package io.hops.hopsworks.api.modelregistry.models.tags;

import io.hops.hopsworks.api.modelregistry.ModelRegistryTagResource;
import io.hops.hopsworks.api.modelregistry.models.ModelUtils;
import io.hops.hopsworks.api.modelregistry.models.dto.ModelDTO;
import io.hops.hopsworks.common.api.ResourceRequest;
import io.hops.hopsworks.common.dataset.util.DatasetHelper;
import io.hops.hopsworks.common.dataset.util.DatasetPath;
import io.hops.hopsworks.common.provenance.state.dto.ProvStateDTO;
import io.hops.hopsworks.exceptions.DatasetException;
import io.hops.hopsworks.persistence.entity.dataset.DatasetType;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@TransactionAttribute(TransactionAttributeType.NEVER)
public class ModelTagResource extends ModelRegistryTagResource {
  
  @EJB
  private ModelUtils modelUtils;
  @EJB
  private DatasetHelper datasetHelper;
  
  private ModelDTO model;
  private ProvStateDTO provState;
  
  /**
   * Sets the model and prov state of the tag resource
   *
   * @param model
   * @param provState
   */
  public void setModel(ModelDTO model, ProvStateDTO provState) {
    this.model = model;
    this.provState = provState;
  }
  
  @Override
  protected DatasetPath getDatasetPath() throws DatasetException {
    return datasetHelper.getDatasetPath(project, modelUtils.getModelFullPath(modelRegistry, model.getName(),
      model.getVersion()), DatasetType.DATASET);
  }
  
  @Override
  protected String getItemId() {
    return provState.getMlId();
  }
  
  @Override
  protected ResourceRequest.Name getItemType() {
    return ResourceRequest.Name.MODELS;
  }
}