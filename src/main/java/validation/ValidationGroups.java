package validation;

import jakarta.validation.groups.Default;

public interface ValidationGroups {
    interface PostAndPut extends Default { }

    interface Patch extends Default { }
}
