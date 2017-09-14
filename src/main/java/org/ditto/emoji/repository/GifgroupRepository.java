package org.ditto.emoji.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.ditto.emoji.model.Gifgroup;

@RepositoryConfig(cacheName = "GifgroupCache")
public interface GifgroupRepository extends IgniteRepository<Gifgroup, String> {
}