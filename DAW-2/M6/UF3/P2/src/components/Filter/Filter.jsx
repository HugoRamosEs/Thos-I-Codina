import { memo } from "react";

const Filter = memo(function Filter({ item, type, subType, filterCheck, showAll }) {
  console.log("Filter");
  return (
    <>
      {showAll && (
        <label>
          <div>
            <input type="checkbox" value={item[subType]} defaultChecked={filterCheck} data-type={type} />
            {item[subType]}
          </div>
        </label>
      )}
    </>
  );
});

export default Filter;