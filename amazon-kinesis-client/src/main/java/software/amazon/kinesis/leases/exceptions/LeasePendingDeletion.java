/*
 * Copyright 2020 Amazon.com, Inc. or its affiliates.
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package software.amazon.kinesis.leases.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import software.amazon.kinesis.common.StreamIdentifier;
import software.amazon.kinesis.leases.Lease;
import software.amazon.kinesis.leases.ShardInfo;

/**
 * Helper class for cleaning up leases.
 */
@Accessors(fluent = true)
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"queueEntryTimeMillis"})
public class LeasePendingDeletion {
    private final StreamIdentifier streamIdentifier;
    private final Lease lease;
    private final ShardInfo shardInfo;
    private final long queueEntryTimeMillis = System.currentTimeMillis();

    public long timeSpentInQueueMillis() {
        return System.currentTimeMillis() - queueEntryTimeMillis;
    }
}
