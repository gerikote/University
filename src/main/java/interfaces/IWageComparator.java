package interfaces;

import people.AcademicStaff;
import people.Staff;

@FunctionalInterface
public interface IWageComparator<T extends Staff> {
    int compareWages(T staff1,T staff2);
}
