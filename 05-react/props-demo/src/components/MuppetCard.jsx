function MuppetCard(props) {
  const name = props.name;
  const id = props.id;
  const description = props.description;

  return (
    <div className="card shadow mb-3">
      <div className="card-body">
        <h5 className="card-title">
          {name} (id: {id})
        </h5>
        <p className="card-text">Description: {description}</p>
      </div>
    </div>
  );
}

// default export
export default MuppetCard;
