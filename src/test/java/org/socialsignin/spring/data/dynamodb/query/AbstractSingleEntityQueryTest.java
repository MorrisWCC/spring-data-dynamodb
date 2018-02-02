/**
 * Copyright © 2013 spring-data-dynamodb (https://github.com/derjust/spring-data-dynamodb)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socialsignin.spring.data.dynamodb.query;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.socialsignin.spring.data.dynamodb.core.DynamoDBOperations;
import org.socialsignin.spring.data.dynamodb.domain.sample.User;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class AbstractSingleEntityQueryTest {

    @Mock
    private DynamoDBOperations dynamoDBOperations;
    @Mock
    private User entity;

    private AbstractSingleEntityQuery<User> underTest;

    @Before
    public void setUp() {
        underTest = new AbstractSingleEntityQuery<User>(dynamoDBOperations, User.class) {
            @Override
            public User getSingleResult() {
                return entity;
            }
        };
    }

    @Test
    public void testGetResultList() {
        List<User> actual = underTest.getResultList();

        assertEquals(1, actual.size());
        assertEquals(entity, actual.get(0));
    }

}
