/*
 * This file is part of Hopsworks
 * Copyright (C) 2018, Logical Clocks AB. All rights reserved
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

package io.hops.hopsworks.common.serving;

import io.hops.hopsworks.common.dao.kafka.TopicDTO;
import io.hops.hopsworks.persistence.entity.serving.Serving;

public class ServingWrapper {
  private Serving serving;

  private ServingStatusEnum status;
  private Integer availableReplicas;
  private String hopsworksInferencePath;
  private String modelServerInferencePath;
  private Integer internalPort;
  
  private TopicDTO kafkaTopicDTO;

  public ServingWrapper(Serving serving) {
    this.serving = serving;
  }

  public Serving getServing() {
    return serving;
  }

  public void setServing(Serving serving) {
    this.serving = serving;
  }

  public ServingStatusEnum getStatus() {
    return status;
  }

  public void setStatus(ServingStatusEnum status) {
    this.status = status;
  }

  public Integer getAvailableReplicas() {
    return availableReplicas;
  }

  public void setAvailableReplicas(Integer availableReplicas) {
    this.availableReplicas = availableReplicas;
  }

  public Integer getInternalPort() { return internalPort; }
  public void setInternalPort(Integer internalPort) { this.internalPort = internalPort; }

  public String getHopsworksInferencePath() { return hopsworksInferencePath; }
  public void setHopsworksInferencePath(String hopsworksInferencePath) {
    this.hopsworksInferencePath = hopsworksInferencePath;
  }
  
  public String getModelServerInferencePath() { return modelServerInferencePath; }
  public void setModelServerInferencePath(String modelServerInferencePath) {
    this.modelServerInferencePath = modelServerInferencePath;
  }
  
  public TopicDTO getKafkaTopicDTO() {
    return kafkaTopicDTO;
  }

  public void setKafkaTopicDTO(TopicDTO kafkaTopicDTO) {
    this.kafkaTopicDTO = kafkaTopicDTO;
  }
}
