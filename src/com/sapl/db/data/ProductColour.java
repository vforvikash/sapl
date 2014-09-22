package com.sapl.db.data;

import java.io.Serializable;

/**
 * @author Vikash
 *
 */
public class ProductColour {
	 	/**
		 * @author vikash
		 *
		 */
		public class Id implements Serializable {
			private static final long serialVersionUID = 1L;

			private long productId;
			private long colourId;
			
			public long getProductId() {
				return productId;
			}
			public void setProductId(long productId) {
				this.productId = productId;
			}
			public long getColourId() {
				return colourId;
			}
			public void setColourId(long colourId) {
				this.colourId = colourId;
			}
	    }
			
		private Id id = new Id();

		/**
		 * @return Returns the id.
		 */
		public Id getId() {
			return id;
		}

		/**
		 * @param id The id to set.
		 */
		public void setId(Id id) {
			this.id = id;
		}
}
