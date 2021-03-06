/*
 * Copyright 2015 Evgeny Dolganov (evgenij.dolganov@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package och.comp.db.base.universal.query;

import och.comp.db.base.universal.field.RowField;

public class AndCondition extends WhereCondition {
	
	private RowField<?>[] fields;

	public AndCondition(RowField<?>... fields) {
		this.fields = fields;
	}
	
	@Override
	public void setWhereQuery(StringBuilder sb) {
		boolean isFirst = true;
		for (RowField<?> q : fields) {
			if( ! isFirst){
				sb.append(" AND");
			}
			isFirst = false;
			sb.append(' ').append(q.fieldName()).append("=?");
		}	
	}

	@Override
	public RowField<?>[] values() {
		return fields;
	}

	
}
