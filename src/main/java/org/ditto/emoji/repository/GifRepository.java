package org.ditto.emoji.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.ditto.emoji.model.Gif;

@RepositoryConfig(cacheName = "GifCache")
public interface GifRepository extends IgniteRepository<Gif, String> {
}